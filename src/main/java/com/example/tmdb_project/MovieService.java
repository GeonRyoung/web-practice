package com.example.tmdb_project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final RestTemplate restTemplate;

    @Value("${tmdb.api.key}")
    private String apikey;

    public MovieService(MovieRepository movieRepository, RestTemplate restTemplate) {
        this.movieRepository = movieRepository;
        this.restTemplate = restTemplate;
    }

    public void fetchPopularMoviesAndSave(){
        String url = "https://api.themoviedb.org/3/movie/popular?api_key="
                + apikey
                + "&language=ko-KR";

        TmdbResponseDto response = restTemplate.getForObject(url, TmdbResponseDto.class);

        if(response !=null && response.getResults() != null){

            for(TmdbMovieDto tmdbMovie : response.getResults()){
                Movie movie = new Movie();
                movie.setId(tmdbMovie.getId());
                movie.setTitle(tmdbMovie.getTitle());
                movie.setOverview(tmdbMovie.getOverview());
                if(tmdbMovie.getReleaseDate() != null && !tmdbMovie.getReleaseDate().isEmpty());{
                    int year = Integer.parseInt(tmdbMovie.getReleaseDate().substring(0, 4));
                    movie.setReleaseYear(year);
                }
                movie.setPosterPath(tmdbMovie.getPosterPath());

                movieRepository.save(movie);
            }
        }
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
