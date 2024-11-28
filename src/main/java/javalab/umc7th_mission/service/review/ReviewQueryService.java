package javalab.umc7th_mission.service.review;

import java.util.ArrayList;
import java.util.List;
import javalab.umc7th_mission.converter.review.ReviewConverter;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.User;
import javalab.umc7th_mission.dto.review.ReviewListResponseDTO;
import javalab.umc7th_mission.dto.review.ReviewResponseDTO;
import javalab.umc7th_mission.global.PageResponseDTO;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.global.exception.GeneralException;
import javalab.umc7th_mission.repository.ReviewRepository;
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
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public PageResponseDTO<ReviewListResponseDTO> getReviewWithUserID(Integer userId, Pageable pageable) {

        User user = userRepository.findById(userId).orElseThrow(
            () -> new GeneralException(ErrorStatus.USER_NOT_FOUND)
        );

        Page<Review> reviewList = reviewRepository.findAllByUser(user, pageable);

        List<ReviewResponseDTO> reviewListResponseDTO = reviewList.stream()
            .map(ReviewConverter::toReviewResponseDTO)
            .toList();

        return new PageResponseDTO<>(
            pageable.getPageNumber(),
            reviewList.hasNext(),
            ReviewConverter.toReviewListResponseDTO(reviewListResponseDTO)
        );
    }
}
