package javalab.umc7th_mission.converter.mission;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.dto.mission.MissionRequestDTO;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO missionRequestDTO, Store store){
        return Mission.builder()
            .content(missionRequestDTO.content())
            .points(missionRequestDTO.points())
            .deadline(missionRequestDTO.deadline())
            .store(store)
            .build();
    }

}
