package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Creator;
import com.DiplomskiRad.Videoteka.repositories.CreatorRepository;
import com.DiplomskiRad.Videoteka.service.implementation.CreatorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorServiceImp implements CreatorService {
    private final CreatorRepository creatorRepository;

    public CreatorServiceImp(CreatorRepository creatorRepository){
        this.creatorRepository=creatorRepository;
    }


    @Override
    public void deleteCreatorById(Long id) {
        creatorRepository.deleteById(id);
    }

    @Override
    public Creator findCreatorById(Long id) {
        return creatorRepository.findById(id).get();
    }

    @Override
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }
}
