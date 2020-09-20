package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Country;

import java.util.List;

public interface CountryService {

     void deleteCountryById(Long id);
     Country findCountryById(Long id);
     List<Country> getAllCountries();

}
