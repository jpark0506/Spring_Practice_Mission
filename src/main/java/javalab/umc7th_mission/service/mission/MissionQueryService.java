package javalab.umc7th_mission.service.mission;

import java.util.ArrayList;
import java.util.List;
import javalab.umc7th_mission.converter.mission.MissionConverter;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.domain.User;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.UserMission;
import javalab.umc7th_mission.dto.mission.MissionListResponseDTO;
import javalab.umc7th_mission.dto.mission.MissionResponseDTO;
import javalab.umc7th_mission.global.PageResponseDTO;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.global.exception.GeneralException;
import javalab.umc7th_mission.repository.MissionRepository;
import javalab.umc7th_mission.repository.StoreRepository;
import javalab.umc7th_mission.repository.UserMissionRepository;
import javalab.umc7th_mission.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MissionQueryService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    public PageResponseDTO<MissionListResponseDTO> getMissionByStoreId(Integer storeId, Pageable pageable){
        Store store = storeRepository.findById(storeId).orElseThrow(
            () -> new GeneralException(ErrorStatus.STORE_NOT_FOUND)
        );

        Page<Mission> missionPage = missionRepository.findAllByStore(store, pageable);

        List<MissionResponseDTO> missionResponseDTOList = missionPage.stream()
            .map(MissionConverter::toMissionResponseDTO)
            .toList();

        return new PageResponseDTO<>(
            pageable.getPageNumber(),
            missionPage.hasNext(),
            MissionConverter.toMissionListResponseDTO(missionResponseDTOList)
        );
    }

    public PageResponseDTO<MissionListResponseDTO> getChallengingMissionListByUserId(Integer userId, Pageable pageable){

        User user = userRepository.findById(userId).orElseThrow(
            () -> new GeneralException(ErrorStatus.USER_NOT_FOUND)
        );

        Page<UserMission> userMissionPage = userMissionRepository.findUserMissionByUserAndMissionStatus(
            user, MissionStatus.CHALLENGING, pageable
        );

        List<MissionResponseDTO> missionList = userMissionPage.stream()
            .map(UserMission::getMission)
            .map(MissionConverter::toMissionResponseDTO)
            .toList();

        return new PageResponseDTO<>(
            pageable.getPageNumber(),
            userMissionPage.hasNext(),
            MissionConverter.toMissionListResponseDTO(missionList)
        );
    }

}
