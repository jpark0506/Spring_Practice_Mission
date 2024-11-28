package javalab.umc7th_mission.global;

public record PageResponseDTO<T>(
    int page,
    boolean hasNext,
    T result
) {


}
