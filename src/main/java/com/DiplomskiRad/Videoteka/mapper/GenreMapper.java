package com.DiplomskiRad.Videoteka.mapper;

import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.dto.GenreDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);
    Genre toEntity (GenreDto genreDto);
    GenreDto toDto (Genre genre);
}
