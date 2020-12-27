package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Cartoon;
import com.DiplomskiRad.Videoteka.domain.Series;
import com.DiplomskiRad.Videoteka.dto.CartoonDto;

import java.util.List;

public interface CartoonService {


    CartoonDto findCartoonById(Long id);

    List<CartoonDto> findAllCartoons();

    void deleteCartoonById(Long id);

    List<CartoonDto> findByKeyword(String keyword);

    List<CartoonDto> getAllCartoonGenres();

    void addCartoon(CartoonDto cartoonDto);


    List<CartoonDto>listOfSeriesOnGenre(String searchGenre);

    List<CartoonDto>searchEngine(String searchGenre,String keyword);

}
