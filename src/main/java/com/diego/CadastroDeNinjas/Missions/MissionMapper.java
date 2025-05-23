package com.diego.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Component;

@Component
public class MissionMapper {
    public MissionModel map(MissionDTO missionDTO){
        MissionModel missionModel = new MissionModel();
        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setMissionLevel(missionDTO.getMissionLevel());
        missionModel.setNinjas(missionDTO.getNinjas());

        return missionModel;
    }

    public MissionDTO map(MissionModel missionModel){
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setMissionLevel(missionModel.getMissionLevel());
        missionDTO.setNinjas(missionDTO.getNinjas());

        return missionDTO;
    }
}