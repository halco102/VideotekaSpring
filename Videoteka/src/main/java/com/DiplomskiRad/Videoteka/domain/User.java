
package com.DiplomskiRad.Videoteka.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2,max = 40,message = "First name has to be between 2 and 40")
    @Column(name = "fist_name")
    private String firstName;

    @Size(min = 2,max = 40,message = "Last name has to be between 2 and 40")
    @Column(name = "last_name")
    private String lastName;

    @Size(min = 2,max = 40,message = "Username has to be between 2 and 40")
    @Column(name = "username",unique = true)
    private String userName;

    @Size(min=2,max = 66,message = "Password has to be from 2 and 40")
    @Column(name = "password",length = 255)
    private String password;

    @Size(min=2,max = 66,message = "Password has to be from 2 and 40")
    @Column(name = "confirm_password",length = 255)
    private String confirmPassword;


    @Size(min=2,max=50,message = "Email has to be between 2 and 40")
    @Column(name = "email", unique = true)
    private String eMail;



    public User(String firstName, String lastName, String userName, String password, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user_id" ,referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    Set<Role> roleSet = new HashSet<>();


    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Role> getUserRoleSet() {
        return roleSet;
    }

    public void setUserRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
