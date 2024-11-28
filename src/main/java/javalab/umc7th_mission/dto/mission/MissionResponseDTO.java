package javalab.umc7th_mission.dto.mission;

import java.util.Date;
import lombok.Builder;

@Builder
public record MissionResponseDTO(
    Integer missionId,
    String content,
    Integer points,
    Date deadline
) {

}
