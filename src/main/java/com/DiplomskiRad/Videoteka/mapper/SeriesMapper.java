package com.DiplomskiRad.Videoteka.mapper;

import com.DiplomskiRad.Videoteka.domain.Series;
import com.DiplomskiRad.Videoteka.dto.SeriesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeriesMapper {
    SeriesMapper INSTANCE = Mappers.getMapper(SeriesMapper.class);
    Series toEntity (SeriesDto seriesDto);
    SeriesDto toDto (Series series);
}
