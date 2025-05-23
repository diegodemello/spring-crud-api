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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninjaDTO){
        return ninjaService.addNinja(ninjaDTO);
    }

    @GetMapping("/list")
    public List<NinjaDTO> listAllNinjas(){
        return ninjaService.listAllNinjas();
    }

    @GetMapping("/list/{id}")
    public NinjaDTO listNinjaId(@PathVariable Long id){
        return ninjaService.listNinjaById(id);
    }

    @PutMapping("/change/{id}")
    public NinjaDTO changeNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        return ninjaService.changeNinja(id, ninjaDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
    }

}