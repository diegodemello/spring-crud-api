package com.diego.CadastroDeNinjas.controllers;

import com.diego.CadastroDeNinjas.dto.NinjaDTO;
import com.diego.CadastroDeNinjas.services.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {
    private final NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/add")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja.")
    })
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninjaDTO){
        NinjaDTO ninja = ninjaService.addNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja " + ninja.getName() + " criado com sucesso!");
    }

    @GetMapping("/list")
    @Operation(summary = "Lista todos os ninjas", description = "Rota lista os ninjas cadastrados.")
    public ResponseEntity<List<NinjaDTO>> listAllNinjas(){
        return ResponseEntity.ok().body(ninjaService.listAllNinjas());
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "Lista ninja por ID", description = "Rota lista um ninja através do seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<?> listNinjaId(@PathVariable Long id){
        if(ninjaService.listNinjaById(id) != null){
            NinjaDTO ninja = ninjaService.listNinjaById(id);
            return ResponseEntity.ok().body(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " não existe.");
        }
    }

    @PutMapping("/change/{id}")
    @Operation(summary = "Altera o ninja por ID", description = "Rota altera o ninja e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, impossível alterar.")
    })
    public ResponseEntity<String> changeNinja(
            @Parameter(description = "Usuário manda o ID no caminho da requisição.") @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisição.") @RequestBody NinjaDTO ninjaDTO){
        if(ninjaService.listNinjaById(id) != null){
            ninjaService.changeNinja(id, ninjaDTO);
            return ResponseEntity.ok().body("Ninja com o ID " + id + " alterado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " não existe.");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta o ninja por ID", description = "Rota deleta o ninja do banco de dados.")
    public ResponseEntity<String> deleteNinja(@Parameter(description = "Usuário manda o ID no caminho da requisição.") @PathVariable Long id){
        if(ninjaService.listNinjaById(id) != null){
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok().body("Ninja com o ID " + id + " deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " não existe.");
        }
    }
}