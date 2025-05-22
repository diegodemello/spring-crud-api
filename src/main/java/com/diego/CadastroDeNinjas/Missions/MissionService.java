package com.diego.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {
    private MissionRepository missionRepository;
    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<MissionModel> listMissions(){
        return missionRepository.findAll();
    }
}
