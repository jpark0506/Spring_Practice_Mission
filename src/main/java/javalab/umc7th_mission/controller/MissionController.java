package javalab.umc7th_mission.controller;

import javalab.umc7th_mission.dto.mission.MissionListResponseDTO;
import javalab.umc7th_mission.global.PageResponseDTO;
import javalab.umc7th_mission.service.mission.MissionQueryService;
import javalab.umc7th_mission.validation.annotation.CheckPage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import javalab.umc7th_mission.dto.usermission.UserMissionRequestDTO;
import javalab.umc7th_mission.global.ApiResponse;
import javalab.umc7th_mission.service.mission.MissionCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/challenge")
    public ApiResponse<Integer> challengeMission(
        @Valid @RequestBody UserMissionRequestDTO userMissionRequestDTO) {
        return ApiResponse.onSuccess(
            missionCommandService.challengeMission(userMissionRequestDTO)
        );
    }

    @PatchMapping("/complete/{missionId}/user/{userId}")
    public ApiResponse<Boolean> completeMission(
        @PathVariable Integer missionId,
        @PathVariable Integer userId
    ){
        missionCommandService.completeMission(missionId,userId);
        return ApiResponse.onSuccess(
            true
        );
    }

    @GetMapping("/list/challenge/{userId}")
    public ApiResponse<PageResponseDTO<MissionListResponseDTO>> challengeMissionList(
        @CheckPage @RequestParam Integer page,
        @PathVariable Integer userId
    ) {
        Pageable pageable = PageRequest.of(page-1, 10);
        return ApiResponse.onSuccess(missionQueryService.getChallengingMissionListByUserId(
            userId, pageable
        ));
    }

    @GetMapping("/list/{storeId}")
    public ApiResponse<PageResponseDTO<MissionListResponseDTO>> getMissionListByStoreId(
        @CheckPage @RequestParam Integer page,
        @PathVariable Integer storeId
    ) {
        Pageable pageable = PageRequest.of(page-1, 10);
        return ApiResponse.onSuccess(missionQueryService.getMissionByStoreId(
            storeId, pageable
        ));
    }

}
