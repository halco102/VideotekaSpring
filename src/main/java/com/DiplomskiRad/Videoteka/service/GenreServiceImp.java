package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.dto.GenreDto;
import com.DiplomskiRad.Videoteka.mapper.GenreMapper;
import com.DiplomskiRad.Videoteka.repositories.GenreRepository;
import com.DiplomskiRad.Videoteka.service.implementation.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImp implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenreServiceImp(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public GenreDto findByName(String searchGenre) {
        return genreMapper.toDto(this.genreRepository.findByName(searchGenre));
    }

    @Override
    public List<GenreDto> findAllGenre() {
        return this.genreRepository.findAll().stream().map(genreMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public GenreDto findGenreById(Long id) {
        return genreMapper.toDto(this.genreRepository.findById(id).get());
    }


    @Override
    public void save(GenreDto genre) {
        Genre temp = new Genre();
        temp = this.genreMapper.toEntity(genre);
        genreRepository.save(temp);
    }

}
