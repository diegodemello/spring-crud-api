package com.diego.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {

    @PostMapping("add")
    public void addMission(MissionModel missionModel){

    }

    @GetMapping("/list")
    public List<MissionModel> listMissions(){
        return listMissions();
    }

    @GetMapping("/id")
    public MissionModel missionModel(Long id){
        return missionModel(id);
    }

    @PutMapping("/changeID")
    public void changeMission(MissionModel missionModel){

    }

    @DeleteMapping("/id")
    public void deleteMission(MissionModel missionModel){

    }
}
