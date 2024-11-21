package javalab.umc7th_mission.service.store;

import javalab.umc7th_mission.converter.mission.MissionConverter;
import javalab.umc7th_mission.converter.review.ReviewConverter;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.dto.mission.MissionCreateDTO;
import javalab.umc7th_mission.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.global.exception.GeneralException;
import javalab.umc7th_mission.repository.ReviewRepository;
import javalab.umc7th_mission.repository.StoreRepository;
import javalab.umc7th_mission.repository.querydsl.MissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class StoreCommandService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    public Integer addStoreReview(ReviewRequestDTO reviewRequestDTO){

        Store store = storeRepository.findById(reviewRequestDTO.storeId()).orElseThrow(
            () -> new GeneralException(ErrorStatus.STORE_NOT_FOUND)
        );

        Review review = ReviewConverter.toReview(
            reviewRequestDTO,
            store
        );

        reviewRepository.save(review);

        return review.getId();
    }

    public Integer addStoreMission(MissionCreateDTO missionCreateDTO){
        Store store = storeRepository.findById(missionCreateDTO.storeId()).orElseThrow(
            () -> new GeneralException(ErrorStatus.STORE_NOT_FOUND)
        );
        Mission mission = MissionConverter.toMission(
            missionCreateDTO,
            store
        );

        missionRepository.save(mission);
        store.addMission(mission);

        return mission.getId();
    }

}
