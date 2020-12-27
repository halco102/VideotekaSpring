package com.DiplomskiRad.Videoteka.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private MovieDto movie;
    private SeriesDto series;
    private CartoonDto cartoon;
    private UserDto user;
}
