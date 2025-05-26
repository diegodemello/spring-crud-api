package com.diego.CadastroDeNinjas.Ninjas;

import com.diego.CadastroDeNinjas.Missions.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_ninja")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "mission")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private int age;
    @Column(name = "rank")
    private String rank;
    @ManyToOne
    @JoinColumn(name = "missions_id")
    private MissionModel mission;
}