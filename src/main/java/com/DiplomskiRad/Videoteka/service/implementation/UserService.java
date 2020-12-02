package com.DiplomskiRad.Videoteka.service.implementation;


import com.DiplomskiRad.Videoteka.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findUserById(Long id);

    List<User> findAllUsers();

    User checkIfUserIsInDatabase(String username,String password);

    Boolean exists(String username,String password);

    Optional<User> findUserByUserName(String userName);

    User save(User user);

    Boolean checkIfPasswordMach(String password,String repeatPassword);

    boolean checkEmail(String email);

    boolean checkIfUsernameExists(String username);

    boolean validation(String username, String email, String password, String repeatPassword);
}
