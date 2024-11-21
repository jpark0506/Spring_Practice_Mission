package javalab.umc7th_mission.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import javalab.umc7th_mission.validation.annotation.ExistCategories;

public record ReviewRequestDTO(
    @ExistCategories
    Integer storeId,
    @Min(1)
    @Max(5)
    Integer reviewRating,
    @Size(min = 1, max = 50)
    String reviewContent
) {

}
