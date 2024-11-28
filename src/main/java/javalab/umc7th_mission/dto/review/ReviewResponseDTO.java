package javalab.umc7th_mission.dto.review;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record ReviewResponseDTO(
    String nickname,
    Integer reviewRating,
    String reviewContent,
    LocalDateTime reviewDate
) {

}
