
package com.DiplomskiRad.Videoteka.dto;


import com.DiplomskiRad.Videoteka.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @Size(min = 2,max = 40,message = "First name has to be between 2 and 40")
    private String firstName;
    @Size(min = 2,max = 40,message = "Last name has to be between 2 and 40")
    private String lastName;
    @Size(min = 2,max = 40,message = "Username has to be between 2 and 40")
    private String userName;
    @Size(min=2,max = 66,message = "Password has to be from 2 and 40")
    private String password;
    @Size(min=2,max = 66,message = "Password has to be from 2 and 40")
    private String confirmPassword;
    @Size(min=2,max=50,message = "Email has to be between 2 and 40")
    private String eMail;
    private Set<RoleDto> roleSet = new HashSet<>();

}
