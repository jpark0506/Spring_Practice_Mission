package javalab.umc7th_mission.dto;

public record UserPointDTO(
    Long userId,
    String name,
    String email,
    String nickname,
    String phoneNumber,
    Integer point
) {

}
