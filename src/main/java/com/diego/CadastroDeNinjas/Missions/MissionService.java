package com.diego.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {
    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;
    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    public List<MissionDTO> listMissions(){
        List<MissionModel> missions = missionRepository.findAll();
        return missions.stream()
                .map(missionMapper::map)
                .collect(Collectors.toList());
    }

    public MissionDTO listMissionById(Long id){
        Optional<MissionModel> missionId = missionRepository.findById(id);
        return missionId.map(missionMapper::map).orElse(null);
    }

    public MissionDTO addMission(MissionDTO missionDTO){
        MissionModel missionModel = missionMapper.map(missionDTO);
        missionModel = missionRepository.save(missionModel);
        return missionMapper.map(missionModel);
    }

    public void deleteMission(Long id){
        missionRepository.deleteById(id);
    }

    public MissionDTO changeMission(Long id, MissionDTO missionDTO){
        Optional<MissionModel> mission = missionRepository.findById(id);
        if(mission.isPresent()){
            MissionModel missionAt = missionMapper.map(missionDTO);
            missionAt.setId(id);
            MissionModel missionSave = missionRepository.save(missionAt);
            return missionMapper.map(missionSave);
        }
        return null;
    }

}
