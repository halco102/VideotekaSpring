package com.DiplomskiRad.Videoteka.mapper;

import com.DiplomskiRad.Videoteka.domain.Country;
import com.DiplomskiRad.Videoteka.dto.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    Country toEntity (CountryDto countryDto);
    CountryDto toDto (Country country);
}
