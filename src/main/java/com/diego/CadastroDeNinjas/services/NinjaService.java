package com.diego.CadastroDeNinjas.services;

import com.diego.CadastroDeNinjas.dto.NinjaDTO;
import com.diego.CadastroDeNinjas.dto.NinjaMapper;
import com.diego.CadastroDeNinjas.entities.NinjaModel;
import com.diego.CadastroDeNinjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listAllNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listNinjaById(Long id){
        Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
        return ninjaId.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO addNinja(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public void deleteNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO changeNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        if(ninja.isPresent()){
            NinjaModel ninjaAt = ninjaMapper.map(ninjaDTO);
            ninjaAt.setId(id);
            NinjaModel ninjaSave = ninjaRepository.save(ninjaAt);
            return ninjaMapper.map(ninjaSave);
        }
        return null;
    }
}