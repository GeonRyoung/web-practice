package com.example.tmdb_project;

import lombok.Getter;

import java.util.List;

@Getter
public class TmdbResponseDto {
    private List<TmdbMovieDto> results;
}
