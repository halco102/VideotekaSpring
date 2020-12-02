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
    public Genre findByName(String searchGenre) {
        return this.genreRepository.findByName(searchGenre);
    }

    @Override
    public List<Genre> findAllGenre() {
        return this.genreRepository.findAll();
    }

    @Override
    public Genre findGenreById(Long id) {
        return this.genreRepository.findById(id).get();
    }


    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

}
