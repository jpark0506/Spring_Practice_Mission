package javalab.umc7th_mission.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javalab.umc7th_mission.validation.validator.MissionChallengingValidator;

@Documented
@Constraint(validatedBy = MissionChallengingValidator.class)
@Target( {ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsChallenging {
    String message() default "이미 유저가 미션을 도전하고 있습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
