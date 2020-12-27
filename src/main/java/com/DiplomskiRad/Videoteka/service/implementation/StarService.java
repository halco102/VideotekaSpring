package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Star;
import com.DiplomskiRad.Videoteka.dto.StarDto;

import java.util.List;

public interface StarService {

    void deleteStarById(Long id);
    StarDto findStarById(Long id);
    List<StarDto> getAllStars();


}
