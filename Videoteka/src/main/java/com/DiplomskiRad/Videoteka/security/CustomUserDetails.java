package com.DiplomskiRad.Videoteka.security;

import com.DiplomskiRad.Videoteka.domain.User;
import com.DiplomskiRad.Videoteka.repositories.UserRepository;
import com.DiplomskiRad.Videoteka.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;


@Service
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findUserByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Username " + userName + " not found!"));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), passwordEncoder.encode(user.getPassword()),getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities (User user){

        String[] userRoles = user.getUserRoleSet().stream().map((role) -> role.getRole()).toArray(String[]::new);
        Collection<GrantedAuthority> autorities = AuthorityUtils.createAuthorityList(userRoles);
        return autorities;
    }
}
