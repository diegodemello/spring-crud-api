package com.diego.CadastroDeNinjas.Missions;

import com.diego.CadastroDeNinjas.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@Data
@AllArgsConstructor
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MissionLevel missionLevel;
    @OneToMany(mappedBy = "mission")
    @JsonIgnore
    private List<NinjaModel> ninjas;
}