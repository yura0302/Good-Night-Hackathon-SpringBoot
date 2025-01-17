package com.example.goodnight.domain.review.service;

import com.example.goodnight.domain.restaurant.domain.Restaurant;
import com.example.goodnight.domain.restaurant.service.RestaurantService;
import com.example.goodnight.domain.review.domain.Review;
import com.example.goodnight.domain.review.dto.request.ReviewDto;
import com.example.goodnight.domain.review.dto.response.ReviewResDto;
import com.example.goodnight.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final RestaurantService restaurantService;
    private final ReviewRepository  reviewRepository;

    public  void addReview(ReviewDto dto) {
        Restaurant restaurant = restaurantService.findById(dto.getRestaurantId());
        Review review = Review.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .restaurant(restaurant)
                .build();
        reviewRepository.save(review);
    }

    public void removeReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(null);
        reviewRepository.delete(review);
    }
    public void getReviews(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(null);
        Restaurant restaurant = review.getRestaurant();
        ReviewResDto dto = ReviewResDto.builder()
                .restaurantName(restaurant.getRestaurantName())
                .title(review.getTitle())
                .content(review.getContent())
                .build();
        return dto;
    }
    public static void updateReview(Long id, String title, String content){
        Review review = reviewRepository.findById(id).orElseThrow(null);
        review.update(title,content);
    }

    public List<Review> getAllReviews(Pageable pageable , Optional<String>title, Optional<String>content){
        return reviewRepository.findAll(pageable, title, content);
    }


