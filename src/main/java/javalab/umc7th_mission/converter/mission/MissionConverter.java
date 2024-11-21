package javalab.umc7th_mission.converter.mission;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.dto.mission.MissionCreateDTO;

public class MissionConverter {

    public static Mission toMission(MissionCreateDTO missionCreateDTO, Store store){
        return Mission.builder()
            .content(missionCreateDTO.content())
            .points(missionCreateDTO.points())
            .deadline(missionCreateDTO.deadline())
            .store(store)
            .build();
    }



}
