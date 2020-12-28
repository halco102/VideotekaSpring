package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Role;
import com.DiplomskiRad.Videoteka.dto.RoleDto;
import com.DiplomskiRad.Videoteka.mapper.RoleMapper;
import com.DiplomskiRad.Videoteka.repositories.RoleRepository;
import com.DiplomskiRad.Videoteka.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImp(RoleRepository roleRepository, RoleMapper roleMapper){
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDto findByRole(Long id) {
        return this.roleMapper.toDto(roleRepository.findById(id).get());
    }

    @Override
    public void save(RoleDto role) {
        Role temp = new Role();
        temp = this.roleMapper.toEntity(role);
        roleRepository.save(temp);

    }
}
