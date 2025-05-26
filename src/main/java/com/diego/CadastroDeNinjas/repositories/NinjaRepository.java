package com.diego.CadastroDeNinjas.repositories;

import com.diego.CadastroDeNinjas.entities.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
