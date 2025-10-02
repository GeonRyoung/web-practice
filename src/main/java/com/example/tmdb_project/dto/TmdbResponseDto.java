package com.example.tmdb_project.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class TmdbResponseDto {
    private List<TmdbMovieDto> results;
}
