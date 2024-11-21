package javalab.umc7th_mission.dto.usermission;

import javalab.umc7th_mission.validation.annotation.IsChallenging;

@IsChallenging
public record UserMissionRequestDTO(
    Integer userId,
    Integer missionId
) {

}
