package javalab.umc7th_mission.dto.review;

import java.util.List;
import lombok.Builder;

@Builder
public record ReviewListResponseDTO(
    List<ReviewResponseDTO> reviewList
) {

}
