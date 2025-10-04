package com.example.tmdb_project.dto;

import com.example.tmdb_project.entity.Review;
import lombok.Getter;

@Getter
public class ReviewResponseDto {
    private Long id;
    private String content;
    private String username;

    public ReviewResponseDto(Review review) {
        this.id = review.getId();
        this.content = review.getContent();
        this.username = review.getUser().getUsername();
    }
}
