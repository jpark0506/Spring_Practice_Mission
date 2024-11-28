package javalab.umc7th_mission.dto.mission;

import java.util.List;
import lombok.Builder;

@Builder
public record MissionListResponseDTO(
    List<MissionResponseDTO> missionList
) {


}
