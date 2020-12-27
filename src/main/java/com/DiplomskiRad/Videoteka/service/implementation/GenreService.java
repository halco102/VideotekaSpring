package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.dto.GenreDto;

import java.util.List;

public interface GenreService {

    List<GenreDto> findAllGenre();
    GenreDto findGenreById(Long id);
    GenreDto findByName(String searchGenre);
    void save(GenreDto genre);

}
