package com.diego.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listAllNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listNinjaById(Long id){
        Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
        return ninjaId.orElse(null);
    }

    public NinjaModel addNinja(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }
}