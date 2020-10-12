package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "Select * from user where username=?1 and password=?2",nativeQuery = true)
    User checkIfUserIsInDatabase(String username,String password);



    Optional<User> findUserByUserName(String userName);

    @Query(value = "Select role from user as u inner join user_role as ur on u.id = ur.user_id inner join role as r on ur.role_id = r.id ",nativeQuery = true)
    String findRole();

}
