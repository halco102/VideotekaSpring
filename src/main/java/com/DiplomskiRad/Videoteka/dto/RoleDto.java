package com.DiplomskiRad.Videoteka.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long id;
    private String role;
    private Set<UserDto> user;

    public RoleDto(String role){
        this.role = role;
    }

}
