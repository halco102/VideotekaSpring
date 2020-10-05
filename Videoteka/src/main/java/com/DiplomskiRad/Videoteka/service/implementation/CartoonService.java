package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Cartoon;

import java.util.List;

public interface CartoonService {


    Cartoon findCartoonById(Long id);

    List<Cartoon> findAllCartoons();

    void deleteCartoonById(Long id);

    List<Cartoon> findByKeyword(String keyword);

    List<Cartoon> getAllCartoonGenres();

    void addCartoon(Cartoon cartoon);
}
