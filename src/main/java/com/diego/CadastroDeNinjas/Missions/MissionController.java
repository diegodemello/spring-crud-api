package com.diego.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {
    private MissionService missionService;
    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping("add")
    public void addMission(MissionModel missionModel){

    }

    @GetMapping("/list")
    public List<MissionModel> listMissions(){
        return missionService.listMissions();
    }

    @GetMapping("/list/{id}")
    public MissionModel listMissionById(@PathVariable Long id){
        return missionService.listMissionById(id);
    }

    @PutMapping("/changeID")
    public void changeMission(MissionModel missionModel){

    }

    @DeleteMapping("/id")
    public void deleteMission(MissionModel missionModel){

    }
}
