package javalab.umc7th_mission.controller;

import javalab.umc7th_mission.dto.review.ReviewListResponseDTO;
import javalab.umc7th_mission.global.ApiResponse;
import javalab.umc7th_mission.global.PageResponseDTO;
import javalab.umc7th_mission.service.review.ReviewQueryService;
import javalab.umc7th_mission.validation.annotation.CheckPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/{userId}")
    public ApiResponse<PageResponseDTO<ReviewListResponseDTO>> getReviewList(
        @CheckPage @RequestParam(name = "page") Integer page,
        @PathVariable Integer userId) {
        Pageable pageable = PageRequest.of(page-1, 10);

        return ApiResponse.onSuccess(
            reviewQueryService.getReviewWithUserID(userId, pageable));
    }
}
