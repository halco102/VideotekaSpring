package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.repositories.GenreRepository;
import com.DiplomskiRad.Videoteka.service.implementation.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImp implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImp(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAllGenre() {
        return this.genreRepository.findAll();
    }

    @Override
    public Genre findGenreById(Long id) {
        return this.genreRepository.findById(id).get();
    }


}
