package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Role;
import com.DiplomskiRad.Videoteka.dto.RoleDto;
import com.DiplomskiRad.Videoteka.repositories.RoleRepository;

public interface RoleService {

    RoleDto findByRole(Long id);
    void save(RoleDto role);

}
