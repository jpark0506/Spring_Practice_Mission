package javalab.umc7th_mission.dto.mission;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Date;
import javalab.umc7th_mission.validation.annotation.ExistStore;

public record MissionCreateDTO(
    @Size(min = 1, max = 50)
    String content,
    @Min(1000)
    @Max(5000)
    Integer points,
    Date deadline,
    @ExistStore
    Integer storeId
) {
}
