package com.DiplomskiRad.Videoteka.mapper;

import com.DiplomskiRad.Videoteka.domain.Creator;
import com.DiplomskiRad.Videoteka.dto.CountryDto;
import com.DiplomskiRad.Videoteka.dto.CreatorDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreatorMapper {
    CreatorMapper INSTANCE = Mappers.getMapper(CreatorMapper.class);
    Creator toEntity (CreatorDto creatorDto);
    CreatorDto toDto (Creator creator);
}
