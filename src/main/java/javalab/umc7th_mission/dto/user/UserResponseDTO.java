package javalab.umc7th_mission.dto.user;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record UserResponseDTO(
    Integer userId,
    LocalDateTime createdAt
) {

}
