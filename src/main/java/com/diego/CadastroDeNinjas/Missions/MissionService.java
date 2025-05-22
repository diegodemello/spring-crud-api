package com.diego.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    private MissionRepository missionRepository;
    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<MissionModel> listMissions(){
        return missionRepository.findAll();
    }

    public MissionModel listMissionById(Long id){
        Optional<MissionModel> missionId = missionRepository.findById(id);
        return missionId.orElse(null);
    }

    public MissionModel addMission(MissionModel missionModel){
        return missionRepository.save(missionModel);
    }
}
