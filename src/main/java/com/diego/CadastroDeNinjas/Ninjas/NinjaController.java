package com.diego.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {
    private NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/add")
    public void createNinja(NinjaModel ninjaModel){

    }

    @GetMapping("/listall")
    public List<NinjaModel> listAllNinjas(){
        return ninjaService.listAllNinjas();
    }

    @GetMapping("/ninjaID")
    public NinjaModel listNinjaId(){
        return listNinjaId();
    }

    @PutMapping("/changeID")
    public void changeNinja(){

    }

    @DeleteMapping("/deleteID")
    public void deleteNinja(){

    }

}