package javalab.umc7th_mission.repository;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Integer> {

    boolean existsUserMissionByMissionIdAndUserIdAndMissionStatus(Integer missionId, Integer userId, MissionStatus missionStatus);

}
