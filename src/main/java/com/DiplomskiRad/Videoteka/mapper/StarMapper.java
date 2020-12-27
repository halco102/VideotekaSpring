package com.DiplomskiRad.Videoteka.mapper;

import com.DiplomskiRad.Videoteka.domain.Star;
import com.DiplomskiRad.Videoteka.dto.StarDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StarMapper {
    StarMapper INSTANCE = Mappers.getMapper(StarMapper.class);
    Star toEntity (StarDto starDto);
    StarDto toDto (Star star);
}
