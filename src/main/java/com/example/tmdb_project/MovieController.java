package com.example.tmdb_project;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping("/api/movies")
    public Movie createMovie(@RequestBody CreateMovieRequestDto requestDto){
        return movieService.createMovie(requestDto);
    }

    @PutMapping("/api/movies/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody CreateMovieRequestDto requestDto){
        return movieService.updateMovie(id, requestDto);
    }

    @DeleteMapping("/api/movies/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }
}
