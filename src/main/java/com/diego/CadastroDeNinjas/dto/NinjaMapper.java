package com.diego.CadastroDeNinjas.dto;

import com.diego.CadastroDeNinjas.entities.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMission(ninjaDTO.getMission());
        ninjaModel.setEmail(ninjaDTO.getEmail());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
         NinjaDTO ninjaDTO = new NinjaDTO();
         ninjaDTO.setId(ninjaModel.getId());
         ninjaDTO.setAge(ninjaModel.getAge());
         ninjaDTO.setName(ninjaModel.getName());
         ninjaDTO.setRank(ninjaModel.getRank());
         ninjaDTO.setMission(ninjaModel.getMission());
         ninjaDTO.setEmail(ninjaModel.getEmail());

         return ninjaDTO;
    }
}
