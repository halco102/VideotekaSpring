package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findAllGenre();
    Genre findGenreById(Long id);
    Genre findByName(String searchGenre);

    //new

    void save(Genre genre);

}
