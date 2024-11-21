package javalab.umc7th_mission.controller;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import javalab.umc7th_mission.dto.usermission.UserMissionRequestDTO;
import javalab.umc7th_mission.global.ApiResponse;
import javalab.umc7th_mission.service.mission.MissionCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<Integer> challengeMission(
        @Valid @RequestBody UserMissionRequestDTO userMissionRequestDTO){
        return ApiResponse.onSuccess(
            missionCommandService.challengeMission(userMissionRequestDTO)
        );
    }

}
