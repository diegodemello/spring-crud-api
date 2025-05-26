package com.diego.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninjaDTO){
        NinjaDTO ninja = ninjaService.addNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja " + ninja.getName() + " criado com sucesso!");
    }

    @GetMapping("/list")
    public ResponseEntity<List<NinjaDTO>> listAllNinjas(){
        return ResponseEntity.ok().body(ninjaService.listAllNinjas());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listNinjaId(@PathVariable Long id){
        if(ninjaService.listNinjaById(id) != null){
            NinjaDTO ninja = ninjaService.listNinjaById(id);
            return ResponseEntity.ok().body(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " não existe.");
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<String> changeNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        if(ninjaService.listNinjaById(id) != null){
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok().body("Ninja com o ID " + id + " alterado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " não existe.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinja(@PathVariable Long id){
        if(ninjaService.listNinjaById(id) != null){
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok().body("Ninja com o ID " + id + " deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " não existe.");
        }
    }
}