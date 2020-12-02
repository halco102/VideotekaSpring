package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.User;
import com.DiplomskiRad.Videoteka.repositories.UserRepository;
import com.DiplomskiRad.Videoteka.service.implementation.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;


    public UserServiceImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public boolean checkIfUsernameExists(String username) {
        if(this.userRepository.checkUsername(username)!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkEmail(String email) {
        if(this.userRepository.checkEmail(email)!=null){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean validation(User user){
        if(!user.getUserName().isEmpty() || !user.getPassword().isEmpty() || !user.geteMail().isEmpty() || !user.getFirstName().isEmpty()) {
            if (checkIfUsernameExists(user.getUserName()) == false
                    && checkEmail(user.geteMail()) == false
                    && checkIfPasswordMach(user.getPassword(), user.getConfirmPassword()) == true) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Boolean checkIfPasswordMach(String password, String repeatPassword) {
        if(password.equals(repeatPassword)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Optional<User> findUserByUserName(String userName) {
        return this.userRepository.findUserByUserName(userName);
    }

    @Override
    public User save(User user) {
        System.out.println("User saved!");
        return this.userRepository.save(user);
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

    /*
     * primas LoginDto (username and password) ili UserDto koji vec ima password ili ne
     *
     * if findByUsername !)   da li je on pronadjenog Usera jednak password iy DTO koji poslan
     *
     * ako jeste saljes objekta
     *
     * ako ne Bad credentials
     *
     * */

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
