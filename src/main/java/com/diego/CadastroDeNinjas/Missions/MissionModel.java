package com.diego.CadastroDeNinjas.Missions;

import com.diego.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missions")
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MissionLevel missionLevel;
    @OneToMany(mappedBy = "mission")
    private List<NinjaModel> ninjas;
}
