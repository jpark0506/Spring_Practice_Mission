package javalab.umc7th_mission.dto.usermission;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import javalab.umc7th_mission.validation.annotation.IsChallenging;
//
@IsChallenging
public record UserMissionRequestDTO(
    @NotNull(message = "유저 Id는 빈칸일 수 없습니다.")
    Integer userId,
    @NotNull(message = "미션 Id는 빈칸일 수 없습니다.")
    Integer missionId
) {

}
