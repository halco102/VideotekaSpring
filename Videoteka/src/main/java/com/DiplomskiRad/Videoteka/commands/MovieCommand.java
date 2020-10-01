package com.DiplomskiRad.Videoteka.commands;


import com.DiplomskiRad.Videoteka.domain.Genre;

import java.util.HashSet;
import java.util.Set;

public class MovieCommand {
    private Long id;
    private String name;
    private int year;
    private int runtime;
    private Set<GenreCommand> genres = new HashSet<>();

    public MovieCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Set<GenreCommand> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreCommand> genres) {
        this.genres = genres;
    }
}
