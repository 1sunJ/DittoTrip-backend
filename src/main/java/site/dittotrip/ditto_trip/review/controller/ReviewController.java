package site.dittotrip.ditto_trip.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.dittotrip.ditto_trip.auth.service.CustomUserDetails;
import site.dittotrip.ditto_trip.review.domain.dto.ReviewListRes;
import site.dittotrip.ditto_trip.review.domain.dto.ReviewModifyReq;
import site.dittotrip.ditto_trip.review.domain.dto.ReviewSaveReq;
import site.dittotrip.ditto_trip.review.service.ReviewLikeService;
import site.dittotrip.ditto_trip.review.service.ReviewService;
import site.dittotrip.ditto_trip.user.domain.User;

import java.util.List;

/**
 * 1. 리뷰 리스트 조회
 *  - 페이징
 * 2. 리뷰 작성
 * 3. 리뷰 수정
 * 4. 리뷰 삭제
 * 5. 리뷰 좋아요 등록
 * 6. 리뷰 좋아요 삭제
 */
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewLikeService reviewLikeService;

    @GetMapping("/spot/{spotId}/review/list")
    public ReviewListRes reviewList(@AuthenticationPrincipal CustomUserDetails userDetails,
                                    @PathVariable(name = "spotId") Long spotId,
                                    @RequestParam(name = "page") Integer page) {
        User user = userDetails.getUser();
        return reviewService.findReviewList(spotId, user, page);
    }

    @PostMapping("/review")
    public void reviewSave(@AuthenticationPrincipal CustomUserDetails userDetails,
                           @RequestParam(name = "spotVisitId") Long spotVisitId,
                           @RequestBody ReviewSaveReq reviewSaveReq,
                           @RequestParam(name = "images") List<MultipartFile> multipartFiles) {
        User user = userDetails.getUser();
        reviewService.saveReview(spotVisitId, user, reviewSaveReq, multipartFiles);
    }

    @PutMapping("/review/{reviewId}")
    public void reviewModify(@AuthenticationPrincipal CustomUserDetails userDetails,
                             @PathVariable(name = "reviewId") Long reviewId,
                             @RequestBody ReviewModifyReq reviewModifyReq,
                             @RequestParam(name = "images") List<MultipartFile> multipartFiles) {
        User user = userDetails.getUser();
        reviewService.modifyReview(reviewId, user, reviewModifyReq, multipartFiles);
    }

    @DeleteMapping("/review/{reviewId}")
    public void reviewRemove(@AuthenticationPrincipal CustomUserDetails userDetails,
                             @PathVariable(name = "reviewId") Long reviewId) {
        User user = userDetails.getUser();
        reviewService.removeReview(reviewId, user);
    }

    @PostMapping("/review/{reviewId}/like")
    public void reviewLikeSave(@AuthenticationPrincipal CustomUserDetails userDetails,
                               @PathVariable(name = "reviewId") Long reviewId) {
        User user = userDetails.getUser();
        reviewLikeService.saveReviewLike(reviewId, user);
    }

    @DeleteMapping("/review/{reviewId}/like")
    public void reviewLikeRemove(@AuthenticationPrincipal CustomUserDetails userDetails,
                             @PathVariable(name = "reviewId") Long reviewId) {
        User user = userDetails.getUser();
        reviewLikeService.removeReviewLike(reviewId, user);
    }

}
