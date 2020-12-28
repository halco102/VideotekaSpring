package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Creator;
import com.DiplomskiRad.Videoteka.domain.Star;
import com.DiplomskiRad.Videoteka.dto.CreatorDto;

import java.util.List;

public interface CreatorService {

    void deleteCreatorById(Long id);
    CreatorDto findCreatorById(Long id);
    List<CreatorDto> getAllCreators();
}
