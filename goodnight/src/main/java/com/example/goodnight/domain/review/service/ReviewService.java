package com.example.goodnight.domain.review.service;

import com.example.goodnight.domain.restaurant.domain.Restaurant;
import com.example.goodnight.domain.restaurant.service.RestaurantService;
import com.example.goodnight.domain.review.dto.request.ReviewDto;
import com.example.goodnight.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final RestaurantService restaurantService;
    private final ReviewRepository  reviewRepository;

    public  void addReview(ReviewDto dto) {
        Restaurant restaurant = restaurantService.findById(dto.getRestaurantId());
    }
    }


