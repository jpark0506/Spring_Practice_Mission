package javalab.umc7th_mission.dto.mission;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Date;
import javalab.umc7th_mission.validation.annotation.ExistStore;

public record MissionCreateDTO(
    @Size(min = 1, max = 50)
    String content,
    @Size(min=1000, max=5000)
    Integer points,
    @NotEmpty
    Date deadline,
    @ExistStore
    Integer storeId
) {
}
