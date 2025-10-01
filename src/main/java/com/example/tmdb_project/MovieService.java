package com.example.tmdb_project;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(CreateMovieRequestDto requestDto){
        Movie movie = new Movie();
        movie.setId(requestDto.getId());
        movie.setTitle(requestDto.getTitle());
        movie.setOverview(requestDto.getOverview());
        movie.setReleaseYear(requestDto.getReleaseYear());
        movie.setPosterPath(requestDto.getPosterPath());

        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
}
