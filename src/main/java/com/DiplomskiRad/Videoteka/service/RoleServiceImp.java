package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Role;
import com.DiplomskiRad.Videoteka.repositories.RoleRepository;
import com.DiplomskiRad.Videoteka.service.implementation.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @Override
    public Role findByRole(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
