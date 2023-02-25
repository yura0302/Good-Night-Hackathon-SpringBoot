package com.example.goodnight.domain.review.controller;


import com.example.goodnight.domain.review.dto.request.ReviewDto;
import com.example.goodnight.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    @PostMapping("/api/v1/reviews")
    public void createReview(@RequestBody ReviewDto dto){
        reviewService.addReview(dto);
    }
}
