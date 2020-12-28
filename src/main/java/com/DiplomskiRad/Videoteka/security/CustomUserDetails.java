package com.DiplomskiRad.Videoteka.security;

import com.DiplomskiRad.Videoteka.dto.RoleDto;
import com.DiplomskiRad.Videoteka.dto.UserDto;
import com.DiplomskiRad.Videoteka.repositories.UserRepository;
import com.DiplomskiRad.Videoteka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private UserService userService;

    //test
    @Autowired
    private UserRepository userRepository;
    //end

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDto user = userService.findUserByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("Username " + userName + " not found!"));

        return new org.springframework.security.core.userdetails.User(user.getUserName(), passwordEncoder.encode(user.getPassword()),getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities (UserDto user){
        String[] userRoles = user.getRoleSet().stream().map((role) -> role.getRole()).toArray(String[]::new);
//        Collection<GrantedAuthority> autorities = AuthorityUtils.createAuthorityList(userRoles);
        List<GrantedAuthority> autorities = new ArrayList<GrantedAuthority>();
        for(RoleDto role : user.getRoleSet()){
            autorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return autorities;
    }
}
