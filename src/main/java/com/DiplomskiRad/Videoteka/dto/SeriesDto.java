package com.DiplomskiRad.Videoteka.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class SeriesDto {

    private Long id;
    @Size(min=2,max = 40,message = "Title has to be 2 or 40 characters long")
    private String name;
    @Min(value = 1940,message = "Min year is 1940")
    @Max(value = 2021,message = "Max year is 2021")
    private int year;
    @Min(value = 1,message = "Min number of seasons is 1")
    private int seasons;
    private Set<StarDto> stars = new HashSet<>();
    private Set<GenreDto> genres = new HashSet<>();
}
