package javalab.umc7th_mission.converter.usermission;

import java.time.LocalDateTime;
import java.util.Date;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.User;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.UserMission;

public class UserMissionConverter {

    public static UserMission toUserMission(User user, Mission mission
    ){
        return UserMission.builder()
            .user(user)
            .mission(mission)
            .missionStatus(MissionStatus.CHALLENGING)
            .startTime(LocalDateTime.now())
            .build();
    }
}
