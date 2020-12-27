package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Country;
import com.DiplomskiRad.Videoteka.dto.CountryDto;
import com.DiplomskiRad.Videoteka.mapper.CountryMapper;
import com.DiplomskiRad.Videoteka.repositories.CountryRepository;
import com.DiplomskiRad.Videoteka.service.implementation.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImp implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImp(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public void deleteCountryById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public CountryDto findCountryById(Long id) {
        return countryMapper.toDto(countryRepository.findById(id).get());
    }

    @Override
    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream().map(countryMapper::toDto).collect(Collectors.toList());
    }



}
