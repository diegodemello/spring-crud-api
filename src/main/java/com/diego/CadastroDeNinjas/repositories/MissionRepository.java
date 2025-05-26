package com.diego.CadastroDeNinjas.repositories;

import com.diego.CadastroDeNinjas.entities.MissionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<MissionModel, Long> {
}
