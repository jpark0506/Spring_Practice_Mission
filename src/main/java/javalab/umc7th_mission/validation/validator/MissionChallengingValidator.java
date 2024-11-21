package javalab.umc7th_mission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.dto.usermission.UserMissionRequestDTO;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.repository.UserMissionRepository;
import javalab.umc7th_mission.validation.annotation.IsChallenging;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(MissionChallengingValidator.class);

    @Override
    public boolean isValid(UserMissionRequestDTO userMissionRequestDTO, ConstraintValidatorContext context) {

        logger.info("Validating MissionChallenge: missionId={}, userId={}",
            userMissionRequestDTO.missionId(), userMissionRequestDTO.userId());

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
