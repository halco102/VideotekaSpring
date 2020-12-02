package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Country;
import com.DiplomskiRad.Videoteka.repositories.CountryRepository;
import com.DiplomskiRad.Videoteka.service.implementation.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImp implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImp(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void deleteCountryById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Country findCountryById(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }



}
