package com.example.goodnight.domain.review.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class ReviewResDto {
    private String restaurantName;
    private String title;
    private String content;
}
