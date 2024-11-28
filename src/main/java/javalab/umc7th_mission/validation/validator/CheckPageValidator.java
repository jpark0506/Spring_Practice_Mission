package javalab.umc7th_mission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.validation.annotation.CheckPage;

public class CheckPageValidator implements ConstraintValidator<CheckPage,Integer> {


    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext constraintValidatorContext) {
        if (page == null || page < 1) {
            // 에러 메시지 설정
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_VALID.getMessage())
                .addConstraintViolation();
            return false; // 검증 실패
        }
        return true; // 검증 성공
    }
}
