package com.example.goodnight.domain.review.controller;


import com.example.goodnight.domain.review.dto.request.ReviewDto;
import com.example.goodnight.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
