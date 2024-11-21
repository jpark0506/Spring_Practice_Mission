package javalab.umc7th_mission.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.dto.user.UserRequestDTO;
import javalab.umc7th_mission.dto.user.UserResponseDTO;
import javalab.umc7th_mission.global.ApiResponse;
import javalab.umc7th_mission.service.user.UserCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO> join(
        @Valid @RequestBody UserRequestDTO userRequestDTO){
        return ApiResponse.onSuccess(
            userCommandService.joinUser(userRequestDTO)
        );
    }
}
