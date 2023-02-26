package com.example.goodnight.domain.review.controller;


import com.example.goodnight.domain.review.domain.Review;
import com.example.goodnight.domain.review.dto.request.ReviewDto;
import com.example.goodnight.domain.review.dto.response.ReviewResDto;
import com.example.goodnight.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    @PostMapping("/api/v1/reviews")
    public void createReview(@RequestBody ReviewDto dto){
        reviewService.addReview(dto);
    }
    @DeleteMapping("/api/v1/reviews/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.removeReview(id);
    }


    @GetMapping("/api/v1/reviews/{id}")
    public ReviewResDto getReview(@PathVariable Long id){
        return reviewService.getReview(id);
    }


    //전체
    @GetMapping
    public List<Review> getAllReviews(Pageable pageable, Optional<String> title, Optional<String>content){
        return reviewService.getAllReviews(pageable, title, content);
    }

    @PutMapping("/api/v1/reviews")
    public void updateReview(@RequestBody ReviewDto dto ){
        reviewService.updateReview(dto.getRestaurantId(),dto.getTitle(),dto.getContent());
    }
}
