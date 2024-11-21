package javalab.umc7th_mission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.dto.usermission.UserMissionRequestDTO;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.repository.UserMissionRepository;
import javalab.umc7th_mission.validation.annotation.ExistCategories;
import javalab.umc7th_mission.validation.annotation.IsChallenging;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionChallengingValidator implements
    ConstraintValidator<IsChallenging, UserMissionRequestDTO> {

    private final UserMissionRepository userMissionRepository;

    @Override
    public void initialize(IsChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserMissionRequestDTO userMissionRequestDTO, ConstraintValidatorContext context) {

        if(userMissionRequestDTO.missionId() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("미션 Id는 빈칸일 수 없습니다.")
                .addConstraintViolation();
            return false;
        }
        if(userMissionRequestDTO.userId() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("유저 Id는 빈칸일 수 없습니다.")
                .addConstraintViolation();
            return false;
        }

        boolean exist = userMissionRepository.existsUserMissionByMissionIdAndUserIdAndMissionStatus(
            userMissionRequestDTO.missionId(), userMissionRequestDTO.userId(), MissionStatus.CHALLENGING
        );

        if(exist){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                ErrorStatus.USER_ALREADY_CHALLENGING_MISSION.getMessage()
            ).addConstraintViolation();
            return false;
        }

        return true;
    }

}
