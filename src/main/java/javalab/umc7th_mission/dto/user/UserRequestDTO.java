package javalab.umc7th_mission.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import javalab.umc7th_mission.validation.annotation.ExistCategories;

public record UserRequestDTO(
    @NotBlank
    String name,
    @NotNull
    Integer gender,
    @NotNull
    Date birthDate,
    @NotBlank
    @Size(min = 5, max = 12)
    String address,
    @NotBlank
    @Size(min = 5, max = 12)
    String nickname,
    @NotEmpty
    String email,
    @NotEmpty
    @Size(min = 13, max = 13)
    String phoneNumber,
    @ExistCategories
    List<Integer> preferCategory
) {

}
