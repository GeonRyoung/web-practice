package com.example.tmdb_project;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TmdbMovieDto {
    private Long id;
    private String title;
    private String overview;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("poster_path")
    private String posterPath;
}
