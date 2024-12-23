package javalab.umc7th_mission.global.code;

import javalab.umc7th_mission.global.BaseErrorCode;
import javalab.umc7th_mission.global.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    //
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOODCATEGORY4001", "음식 카테고리가 존재하지 않습니다."),

    //
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "가게가 존재하지 않습니다."),

    //
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "지역이 존재하지 않습니다."),

    //
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4001", "미션이 존재하지 않습니다."),

    //
    USER_ALREADY_CHALLENGING_MISSION(HttpStatus.NOT_FOUND, "USERMISSION4001", "이미 유저가 미션을 도전하고 있습니다."),
    USER_NOT_CHALLENGING_MISSION(HttpStatus.BAD_REQUEST, "USERMISSION4002", "도전중인 미션이 아닙니다."),
    //
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER4001", "유저가 존재하지 않습니다"),

    //
    PAGE_NOT_VALID(HttpStatus.BAD_REQUEST, "PAGE4001", "페이지 번호가 적절하지 않습니다"),
    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다.");



    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
            .message(message)
            .code(code)
            .isSuccess(false)
            .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
            .message(message)
            .code(code)
            .isSuccess(false)
            .httpStatus(httpStatus)
            .build()
            ;
    }
}