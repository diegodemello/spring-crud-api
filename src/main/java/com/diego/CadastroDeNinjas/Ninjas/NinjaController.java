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
    public NinjaModel createNinja(@RequestBody NinjaModel ninjaModel){
        return ninjaService.addNinja(ninjaModel);
    }

    @GetMapping("/list")
    public List<NinjaModel> listAllNinjas(){
        return ninjaService.listAllNinjas();
    }

    @GetMapping("/list/{id}")
    public NinjaModel listNinjaId(@PathVariable Long id){
        return ninjaService.listNinjaById(id);
    }

    @PutMapping("/change/{id}")
    public NinjaModel changeNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaModel){
        return ninjaService.changeNinja(id, ninjaModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
    }

}