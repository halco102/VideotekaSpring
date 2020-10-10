package com.DiplomskiRad.Videoteka.service.implementation;


import com.DiplomskiRad.Videoteka.domain.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);

    List<User> findAllUsers();

    User checkIfUserIsInDatabase(String username,String password);

    Boolean exists(String username,String password);

}
