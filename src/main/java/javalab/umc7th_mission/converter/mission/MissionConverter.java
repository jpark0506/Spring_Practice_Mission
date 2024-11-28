package javalab.umc7th_mission.converter.mission;

import java.util.List;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.dto.mission.MissionCreateDTO;
import javalab.umc7th_mission.dto.mission.MissionListResponseDTO;
import javalab.umc7th_mission.dto.mission.MissionResponseDTO;

public class MissionConverter {

    public static Mission toMission(MissionCreateDTO missionCreateDTO, Store store){
        return Mission.builder()
            .content(missionCreateDTO.content())
            .points(missionCreateDTO.points())
            .deadline(missionCreateDTO.deadline())
            .store(store)
            .build();
    }

    public static MissionResponseDTO toMissionResponseDTO(Mission mission){
        return MissionResponseDTO.builder()
            .missionId(mission.getId())
            .content(mission.getContent())
            .points(mission.getPoints())
            .deadline(mission.getDeadline())
            .build();
    }

    public static MissionListResponseDTO toMissionListResponseDTO(List<MissionResponseDTO> missionList){
        return MissionListResponseDTO.builder()
            .missionList(missionList)
            .build();
    }



}
