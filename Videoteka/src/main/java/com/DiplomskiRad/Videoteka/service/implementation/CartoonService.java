package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Cartoon;
import com.DiplomskiRad.Videoteka.domain.Movie;

import java.util.List;

public interface CartoonService {


    Cartoon findCartoonById(Long id);

    List<Cartoon> findAllCartoons();

    void deleteCartoonById(Long id);
}
