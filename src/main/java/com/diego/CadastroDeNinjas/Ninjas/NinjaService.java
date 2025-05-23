package com.diego.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaModel> listAllNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listNinjaById(Long id){
        Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
        return ninjaId.orElse(null);
    }

    public NinjaDTO addNinja(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    public void deleteNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaModel changeNinja(Long id, NinjaModel ninjaModel){
        ninjaModel.setId(id);
        if(ninjaRepository.existsById(id)){
             return ninjaRepository.save(ninjaModel);
        }else{
            return null;
        }
    }
}