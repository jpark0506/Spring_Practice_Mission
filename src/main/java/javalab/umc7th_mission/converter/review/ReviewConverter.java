package javalab.umc7th_mission.converter.review;

import java.util.List;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.domain.User;
import javalab.umc7th_mission.dto.review.ReviewListResponseDTO;
import javalab.umc7th_mission.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.dto.review.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO reviewRequestDTO, Store store){
        return Review.builder()
            .store(store)
            .reviewRating(reviewRequestDTO.reviewRating())
            .reviewContent(reviewRequestDTO.reviewContent())
            .build();
    }

    public static ReviewResponseDTO toReviewResponseDTO(Review review){
        return ReviewResponseDTO.builder()
            .nickname(review.getUser().getNickname())
            .reviewRating(review.getReviewRating())
            .reviewContent(review.getReviewContent())
            .reviewDate(review.getCreatedAt())
            .build();
    }

    public static ReviewListResponseDTO toReviewListResponseDTO(List<ReviewResponseDTO> reviews){
        return ReviewListResponseDTO.builder()
            .reviewList(reviews)
            .build();
    }
}
