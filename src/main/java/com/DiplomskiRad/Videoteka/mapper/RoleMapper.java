package com.DiplomskiRad.Videoteka.mapper;

import com.DiplomskiRad.Videoteka.domain.Role;
import com.DiplomskiRad.Videoteka.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    Role toEntity (RoleDto roleDto);
    RoleDto toDto (Role role);
}
