package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.dto.StarDto;
import com.DiplomskiRad.Videoteka.mapper.StarMapper;
import com.DiplomskiRad.Videoteka.repositories.StarRepository;
import com.DiplomskiRad.Videoteka.service.StarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarServiceImp implements StarService {

    private final StarRepository starRepository;
    private final StarMapper starMapper;

    public StarServiceImp(StarRepository starRepository, StarMapper starMapper) {
        this.starRepository = starRepository;
        this.starMapper = starMapper;
    }

    @Override
    public void deleteStarById(Long id) {
        starRepository.deleteById(id);
    }

    @Override
    public StarDto findStarById(Long id) {
        return this.starMapper.toDto(starRepository.findById(id).get());
    }

    @Override
    public List<StarDto> getAllStars() {
        return starRepository.findAll().stream().map(starMapper::toDto).collect(Collectors.toList());
    }

}
