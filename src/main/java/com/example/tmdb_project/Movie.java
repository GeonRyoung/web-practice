package com.example.tmdb_project;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    private Long id;

    private String title;

    @Column(length = 1000)
    private String overview;

    private Integer releaseYear;

    private String posterPath;
}
