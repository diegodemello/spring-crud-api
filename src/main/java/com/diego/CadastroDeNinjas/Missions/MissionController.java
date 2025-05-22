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
    public MissionModel addMission(@RequestBody MissionModel missionModel){
        return missionService.addMission(missionModel);
    }

    @GetMapping("/list")
    public List<MissionModel> listMissions(){
        return missionService.listMissions();
    }

    @GetMapping("/list/{id}")
    public MissionModel listMissionById(@PathVariable Long id){
        return missionService.listMissionById(id);
    }

    @PutMapping("/change/{id}")
    public MissionModel changeMission(@PathVariable Long id, @RequestBody MissionModel missionModel){
        return missionService.changeMission(id, missionModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMission(@PathVariable Long id){
        missionService.deleteMission(id);
    }
}
