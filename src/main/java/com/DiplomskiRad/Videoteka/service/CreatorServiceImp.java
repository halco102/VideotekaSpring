package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Creator;
import com.DiplomskiRad.Videoteka.dto.CreatorDto;
import com.DiplomskiRad.Videoteka.mapper.CreatorMapper;
import com.DiplomskiRad.Videoteka.repositories.CreatorRepository;
import com.DiplomskiRad.Videoteka.service.implementation.CreatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreatorServiceImp implements CreatorService {
    private final CreatorRepository creatorRepository;
    private final CreatorMapper creatorMapper;

    public CreatorServiceImp(CreatorRepository creatorRepository, CreatorMapper creatorMapper){
        this.creatorRepository=creatorRepository;
        this.creatorMapper = creatorMapper;
    }


    @Override
    public void deleteCreatorById(Long id) {
        creatorRepository.deleteById(id);
    }

    @Override
    public CreatorDto findCreatorById(Long id) {
        return creatorMapper.toDto(creatorRepository.findById(id).get());
    }

    @Override
    public List<CreatorDto> getAllCreators() {
        return creatorRepository.findAll().stream().map(creatorMapper::toDto).collect(Collectors.toList());
    }
}
