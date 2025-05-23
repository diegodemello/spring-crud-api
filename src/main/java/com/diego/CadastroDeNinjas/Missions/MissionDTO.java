package com.diego.CadastroDeNinjas.Missions;

import com.diego.CadastroDeNinjas.Ninjas.NinjaModel;
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