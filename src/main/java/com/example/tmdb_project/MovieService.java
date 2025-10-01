package com.example.tmdb_project;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Movie updateMovie(Long id, CreateMovieRequestDto requestDto){
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if(optionalMovie.isPresent()){
            Movie movie = optionalMovie.get();

            movie.setTitle(requestDto.getTitle());
            movie.setOverview(requestDto.getOverview());
            movie.setReleaseYear(requestDto.getReleaseYear());
            movie.setPosterPath(requestDto.getPosterPath());

            return movieRepository.save(movie);
        } else{
            throw new RuntimeException("Movie not found with id: " + id);
        }

    }

    public void deleteMovie(Long id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
        } else{
            throw new RuntimeException("Movie is not found with id: " + id);
        }
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
}
