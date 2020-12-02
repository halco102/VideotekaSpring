package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.Role;
import com.DiplomskiRad.Videoteka.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "Select * from user where username=?1 and password=?2",nativeQuery = true)
    User checkIfUserIsInDatabase(String username,String password);

    Optional<User> findUserByUserName(String userName);

/*
    @Query(value = "Select * from user where email=?1",nativeQuery = true)
    User checkEmail(String email);*/

    @Query(value = "Select email from user where email = ?1 ",nativeQuery = true)
    String checkEmail(String email);

    @Query(value = "Select username from user where username = ?1",nativeQuery = true)
    String checkUsername(String username);


}
