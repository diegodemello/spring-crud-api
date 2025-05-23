package com.diego.CadastroDeNinjas.Ninjas;

import com.diego.CadastroDeNinjas.Missions.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String rank;
    private MissionModel mission;
}