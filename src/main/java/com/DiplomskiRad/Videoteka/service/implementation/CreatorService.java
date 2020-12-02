package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Creator;
import com.DiplomskiRad.Videoteka.domain.Star;

import java.util.List;

public interface CreatorService {

    void deleteCreatorById(Long id);
    Creator findCreatorById(Long id);
    List<Creator> getAllCreators();
}
