package javalab.umc7th_mission.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javalab.umc7th_mission.validation.validator.CheckPageValidator;

@Constraint(validatedBy = CheckPageValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지 번호를 확인하세요.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
