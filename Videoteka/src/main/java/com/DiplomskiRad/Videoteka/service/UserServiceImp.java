package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.User;
import com.DiplomskiRad.Videoteka.repositories.UserRepository;
import com.DiplomskiRad.Videoteka.service.implementation.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User findUserById(Long id) {
        if(id==1){
            System.out.println("Hello user");
            return userRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User checkIfUserIsInDatabase(String username, String password) {
        return userRepository.checkIfUserIsInDatabase(username,password);
    }

    @Override
    public Boolean exists(String username,String password) {
        if(checkIfUserIsInDatabase(username,password) == null){
            return false;
        }
        return true;
    }
}//end of class
