package com.diego.CadastroDeNinjas.controllers;

import com.diego.CadastroDeNinjas.dto.MissionDTO;
import com.diego.CadastroDeNinjas.services.MissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {
    private final MissionService missionService;
    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping("/add")
    @Operation(summary = "Cria uma nova missão", description = "Rota cria uma nova missão e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão.")
    })
    public ResponseEntity<String> addMission(@RequestBody MissionDTO missionDTO){
        MissionDTO mission = missionService.addMission(missionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão de " + missionDTO.getName() + " criada com sucesso!");
    }

    @GetMapping("/list")
    @Operation(summary = "Lista todas as missões", description = "Rota lista todas as missões cadastradas.")
    public ResponseEntity<List<MissionDTO>> listMissions(){
        return ResponseEntity.ok().body(missionService.listMissions());
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "Lista missão por ID", description = "Rota lista uma missão através do seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Missão não encontrado.")
    })
    public ResponseEntity<?> listMissionById(@PathVariable Long id){
        if(missionService.listMissionById(id) != null){
            MissionDTO mission = missionService.listMissionById(id);
            return ResponseEntity.ok().body(mission);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse id não existe.");
        }
    }

    @PutMapping("/change/{id}")
    @Operation(summary = "Altera a missão por ID", description = "Rota altera a missão e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão alterada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada, impossível alterar.")
    })
    public ResponseEntity<String> changeMission(@PathVariable Long id, @RequestBody MissionDTO missionDTO){
        if(missionService.listMissionById(id) != null){
            missionService.changeMission(id, missionDTO);
            return ResponseEntity.ok().body("Missão com ID " + id + " alterada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " não existe.");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta a missão através do ID", description = "Rota deleta a missão do banco de dados.")
    public ResponseEntity<String> deleteMission(@PathVariable Long id){
        if(missionService.listMissionById(id) != null){
            missionService.deleteMission(id);
            return ResponseEntity.ok().body("Missão com ID " + id + " deletada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " não existe.");
        }
    }
}
