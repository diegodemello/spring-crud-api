package com.diego.CadastroDeNinjas.dto;

import com.diego.CadastroDeNinjas.entities.MissionLevel;
import com.diego.CadastroDeNinjas.entities.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionDTO {
    private Long id;
    private String name;
    private MissionLevel missionLevel;
    private List<NinjaModel> ninjas;
}