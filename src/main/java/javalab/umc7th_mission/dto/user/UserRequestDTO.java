package javalab.umc7th_mission.dto.user;

import jakarta.validation.constraints.*;
import java.util.Date;
import java.util.List;
import javalab.umc7th_mission.domain.enums.Role;
import javalab.umc7th_mission.validation.annotation.ExistCategories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    @NotBlank
    private String name;

    @NotNull
    private Integer gender;

    @NotNull
    private Date birthDate;

    @NotBlank
    @Size(min = 5, max = 12)
    private String address;

    @NotBlank
    @Size(min = 5, max = 12)
    private String nickname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private Role role;

    @NotEmpty
    @Size(min = 13, max = 13)
    private String phoneNumber;

    @ExistCategories
    private List<Integer> preferCategory;
}