package javalab.umc7th_mission.converter.review;

import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.dto.review.ReviewRequestDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO reviewRequestDTO, Store store){
        return Review.builder()
            .store(store)
            .reviewRating(reviewRequestDTO.reviewRating())
            .reviewContent(reviewRequestDTO.reviewContent())
            .build();
    }
}
