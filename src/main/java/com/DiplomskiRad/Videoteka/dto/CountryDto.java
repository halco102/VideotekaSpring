package com.DiplomskiRad.Videoteka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class CountryDto {
    private Long id;
    private String countryName;
}
