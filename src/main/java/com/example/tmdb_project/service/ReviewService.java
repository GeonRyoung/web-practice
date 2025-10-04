package com.example.tmdb_project.service;

import com.example.tmdb_project.dto.ReviewRequestDto;
import com.example.tmdb_project.dto.ReviewResponseDto;
import com.example.tmdb_project.entity.Movie;
import com.example.tmdb_project.entity.Review;
import com.example.tmdb_project.entity.User;
import com.example.tmdb_project.repository.MovieRepository;
import com.example.tmdb_project.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewResponseDto createReview(Long movieId, ReviewRequestDto requestDto, User user){

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화를 찾을 수 없습니다."));

        Review review = new Review();
        review.setContent(requestDto.getContent());
        review.setMovie(movie);
        review.setUser(user);

        reviewRepository.save(review);

        return new ReviewResponseDto(review);
    }

    public List<ReviewResponseDto> getReviewsForMovie(Long movieId){
        List<Review> reviews = reviewRepository.findAllByMovieId(movieId);

        return reviews.stream()
                .map(ReviewResponseDto::new)
                .collect(Collectors.toList());
    }
}
