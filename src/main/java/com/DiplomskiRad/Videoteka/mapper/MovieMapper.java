package com.DiplomskiRad.Videoteka.mapper;

import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    Movie toEntity (MovieDto movieDto);
    MovieDto toDto (Movie movie);
}
