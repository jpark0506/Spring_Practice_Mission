package javalab.umc7th_mission.controller;

import javalab.umc7th_mission.dto.user.UserResponseDTO;
import javalab.umc7th_mission.global.ApiResponse;
import javalab.umc7th_mission.service.region.RegionCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {

    private final RegionCommandService regionCommandService;

    @PostMapping("/{regionId}/store/{storeId}")
    public ApiResponse<Integer> join(
        @PathVariable Integer regionId,
        @PathVariable Integer storeId){
        return ApiResponse.onSuccess(
            regionCommandService.addStoreToRegion(regionId, storeId)
        );
    }
}
