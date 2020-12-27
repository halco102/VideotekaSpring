package com.DiplomskiRad.Videoteka.mapper;

import com.DiplomskiRad.Videoteka.domain.Cartoon;
import com.DiplomskiRad.Videoteka.dto.CartoonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartoonMapper {
    CartoonMapper INSTANCE = Mappers.getMapper(CartoonMapper.class);
    Cartoon toEntity (CartoonDto cartoonDto);
    CartoonDto toDto (Cartoon cartoon);
}
