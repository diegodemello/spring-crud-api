package com.diego.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @PostMapping("/add")
    public void createNinja(NinjaModel ninjaModel){

    }

    @GetMapping("/list")
    public List<NinjaModel> listNinjas(){
        return listNinjas();
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