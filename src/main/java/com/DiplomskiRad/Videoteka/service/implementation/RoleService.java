package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Role;
import com.DiplomskiRad.Videoteka.repositories.RoleRepository;

public interface RoleService {

    Role findByRole(Long id);
    void save(Role role);

}
