package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Country;
import com.DiplomskiRad.Videoteka.dto.CountryDto;

import java.util.List;

public interface CountryService {

     void deleteCountryById(Long id);
     CountryDto findCountryById(Long id);
     List<CountryDto> getAllCountries();

}
