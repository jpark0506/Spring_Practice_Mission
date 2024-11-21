package javalab.umc7th_mission.service.mission;

import javalab.umc7th_mission.converter.usermission.UserMissionConverter;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.User;
import javalab.umc7th_mission.domain.mapping.UserMission;
import javalab.umc7th_mission.dto.usermission.UserMissionRequestDTO;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.global.exception.GeneralException;
import javalab.umc7th_mission.repository.UserMissionRepository;
import javalab.umc7th_mission.repository.UserRepository;
import javalab.umc7th_mission.repository.querydsl.MissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MissionCommandService {

    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    public Integer challengeMission(UserMissionRequestDTO userMissionRequestDTO){

        log.info("Processing MissionChallengeRequest in Service: userId={}, missionId={}",
            userMissionRequestDTO.userId(), userMissionRequestDTO.missionId());

        User user = userRepository.findById(userMissionRequestDTO.userId()).orElseThrow(
            () -> new GeneralException(ErrorStatus.USER_NOT_FOUND)
        );

        Mission mission = missionRepository.findById(userMissionRequestDTO.missionId()).orElseThrow(
            () ->  new GeneralException(ErrorStatus.MISSION_NOT_FOUND)
        );

        UserMission userMission = UserMissionConverter.toUserMission(
            user,mission
        );
        userMissionRepository.save(userMission);
        user.addUserMission(userMission);

        return userMission.getId();
    }
}
