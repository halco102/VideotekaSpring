package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Star;

import java.util.List;

public interface StarService {

    void deleteStarById(Long id);
    Star findStarById(Long id);
    List<Star> getAllStars();


}
