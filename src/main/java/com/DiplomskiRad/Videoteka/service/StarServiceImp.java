package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Star;
import com.DiplomskiRad.Videoteka.repositories.StarRepository;
import com.DiplomskiRad.Videoteka.service.implementation.StarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarServiceImp implements StarService {

    private final StarRepository starRepository;

    public StarServiceImp(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    @Override
    public void deleteStarById(Long id) {
        starRepository.deleteById(id);
    }

    @Override
    public Star findStarById(Long id) {
        return starRepository.findById(id).get();
    }

    @Override
    public List<Star> getAllStars() {
        return starRepository.findAll();
    }

}
