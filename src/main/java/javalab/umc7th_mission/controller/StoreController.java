package javalab.umc7th_mission.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.dto.mission.MissionCreateDTO;
import javalab.umc7th_mission.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.global.ApiResponse;
import javalab.umc7th_mission.service.store.StoreCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/review")
    public ApiResponse<Integer> addStoreReview(
        @Valid @RequestBody  ReviewRequestDTO reviewRequestDTO) {
            return ApiResponse.onSuccess(storeCommandService.addStoreReview(
                reviewRequestDTO
            ));
    }

    @PostMapping("/mission")
    public ApiResponse<Integer> addStoreMission(
        @Valid @RequestBody MissionCreateDTO missionCreateDTO) {
        return ApiResponse.onSuccess(storeCommandService.addStoreMission(
            missionCreateDTO
        ));
    }
}
