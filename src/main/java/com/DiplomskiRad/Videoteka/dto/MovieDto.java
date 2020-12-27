package com.DiplomskiRad.Videoteka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;
    @NotBlank(message = "Title can not be blank!")
    @Size(min=2 , max = 40, message = "Title must be between 2 and 40")
    private String name;
    @Min(value = 1940,message = "Min year value is 1940")
    private int year;
    @Min(value=10,message = "Min runtime value is 10 min")
    private int runtime;
    private Set<GenreDto> genres = new HashSet<>();
    private Set<StarDto>stars = new HashSet<>();

}
