package com.DiplomskiRad.Videoteka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
public class StarDto {
    private Long id;
    private String firstName;
    private String lastName;
    private CountryDto country;
    private Set<MovieDto> movie;

}//endClass
