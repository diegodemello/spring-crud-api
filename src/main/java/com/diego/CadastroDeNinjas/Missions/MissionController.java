package com.diego.CadastroDeNinjas.Missions;

import com.diego.CadastroDeNinjas.Ninjas.NinjaModel;
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
    public MissionDTO addMission(@RequestBody MissionDTO missionDTO){
        return missionService.addMission(missionDTO);
    }

    @GetMapping("/list")
    public List<MissionDTO> listMissions(){
        return missionService.listMissions();
    }

    @GetMapping("/list/{id}")
    public MissionDTO listMissionById(@PathVariable Long id){
        return missionService.listMissionById(id);
    }

    @PutMapping("/change/{id}")
    public MissionDTO changeMission(@PathVariable Long id, @RequestBody MissionDTO missionDTO){
        return missionService.changeMission(id, missionDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMission(@PathVariable Long id){
        missionService.deleteMission(id);
    }
}
