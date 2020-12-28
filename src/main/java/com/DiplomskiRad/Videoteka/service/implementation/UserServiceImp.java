package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.User;
import com.DiplomskiRad.Videoteka.dto.UserDto;
import com.DiplomskiRad.Videoteka.mapper.UserMapper;
import com.DiplomskiRad.Videoteka.repositories.UserRepository;
import com.DiplomskiRad.Videoteka.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImp(UserRepository userRepository, UserMapper userMapper){
        this.userRepository=userRepository;
        this.userMapper = userMapper;
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
    public boolean validation(UserDto user){
        if(!user.getUserName().isEmpty() || !user.getPassword().isEmpty() || !user.getEMail().isEmpty() || !user.getFirstName().isEmpty()) {
            if (checkIfUsernameExists(user.getUserName()) == false
                    && checkEmail(user.getEMail()) == false
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
    public Optional<UserDto> findUserByUserName(String userName) {
        User user = new User();
        user = this.userRepository.findUserByUserName(userName).get();
        Optional<UserDto> optionalUserDto = Optional.ofNullable(this.userMapper.toDto(user));
        return optionalUserDto;
    }

    @Override
    public void save(UserDto user) {
        User temp = new User();
        temp = this.userMapper.toEntity(user);
        this.userRepository.save(temp);
        log.info("User saved!");
    }

    @Override
    public UserDto findUserById(Long id) {
        if(id==1){
            return this.userMapper.toDto(userRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
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
    public UserDto checkIfUserIsInDatabase(String username, String password) {
        return this.userMapper.toDto(userRepository.checkIfUserIsInDatabase(username,password));
    }

    @Override
    public Boolean exists(String username,String password) {
        if(checkIfUserIsInDatabase(username,password) == null){
            return false;
        }
        return true;
    }
}//end of class
