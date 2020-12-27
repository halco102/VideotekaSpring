package com.DiplomskiRad.Videoteka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreatorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private CountryDto country;
}
