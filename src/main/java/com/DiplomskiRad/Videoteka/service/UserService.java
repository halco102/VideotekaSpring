package com.DiplomskiRad.Videoteka.service;


import com.DiplomskiRad.Videoteka.domain.User;
import com.DiplomskiRad.Videoteka.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto findUserById(Long id);

    List<UserDto> findAllUsers();

    UserDto checkIfUserIsInDatabase(String username,String password);

    Boolean exists(String username,String password);

    Optional<UserDto> findUserByUserName(String userName);

    void save(UserDto user);

    Boolean checkIfPasswordMach(String password,String repeatPassword);

    boolean checkEmail(String email);

    boolean checkIfUsernameExists(String username);

    boolean validation(UserDto user);
}
