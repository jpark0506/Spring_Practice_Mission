package javalab.umc7th_mission.converter.user;

import javalab.umc7th_mission.domain.User;
import javalab.umc7th_mission.domain.enums.Gender;
import javalab.umc7th_mission.dto.user.UserRequestDTO;
import javalab.umc7th_mission.dto.user.UserResponseDTO;

public class UserConverter {
    public static UserResponseDTO toUserResponseDTO(User user){
        return UserResponseDTO.builder()
            .userId(user.getId())
            .createdAt(user.getCreatedAt())
            .build();
    }

    public static User toUser(UserRequestDTO userRequestDTO){
        Gender gender = null;

        switch (userRequestDTO.gender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }
        return User.builder()
            .name(userRequestDTO.name())
            .gender(gender)
            .email(userRequestDTO.email())
            .address(userRequestDTO.address())
            .birthDate(userRequestDTO.birthDate())
            .phoneNumber(userRequestDTO.phoneNumber())
            .nickname(userRequestDTO.nickname())
            .build();
    }
}
