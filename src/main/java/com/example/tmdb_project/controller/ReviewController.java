package com.example.tmdb_project.controller;

import com.example.tmdb_project.dto.ReviewRequestDto;
import com.example.tmdb_project.dto.ReviewResponseDto;
import com.example.tmdb_project.security.UserDetailsImpl;
import com.example.tmdb_project.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<ReviewResponseDto> createReview(@PathVariable Long movieId,
                                                          @RequestBody ReviewRequestDto requestDto,
                                                          @AuthenticationPrincipal UserDetailsImpl userDetails){
        ReviewResponseDto responseDto = reviewService.createReview(movieId, requestDto, userDetails.getUser());
        return ResponseEntity.ok(responseDto);
    }
}
