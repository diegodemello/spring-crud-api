package com.diego.CadastroDeNinjas.Missions;

import com.diego.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {
    private MissionService missionService;
    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMission(@RequestBody MissionDTO missionDTO){
        MissionDTO mission = missionService.addMission(missionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão de " + missionDTO.getName() + " criada com sucesso!");
    }

    @GetMapping("/list")
    public ResponseEntity<List<MissionDTO>> listMissions(){
        return ResponseEntity.ok().body(missionService.listMissions());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listMissionById(@PathVariable Long id){
        if(missionService.listMissionById(id) != null){
            MissionDTO mission = missionService.listMissionById(id);
            return ResponseEntity.ok().body(mission);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse id não existe.");
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<String> changeMission(@PathVariable Long id, @RequestBody MissionDTO missionDTO){
        if(missionService.listMissionById(id) != null){
            missionService.changeMission(id, missionDTO);
            return ResponseEntity.ok().body("Missão com ID " + id + " alterada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " não existe.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMission(@PathVariable Long id){
        if(missionService.listMissionById(id) != null){
            missionService.deleteMission(id);
            return ResponseEntity.ok().body("Missão com ID " + id + " deletada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com ID " + id + " não existe.");
        }
    }
}
