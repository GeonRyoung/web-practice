package com.example.tmdb_project;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMovieRequestDto {

    private Long id;
    private String title;
    private String overview;
    private Integer releaseYear;
    private String posterPath;
}
