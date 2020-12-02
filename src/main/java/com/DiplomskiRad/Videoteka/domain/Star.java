package com.DiplomskiRad.Videoteka.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "star")
public class Star {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @ManyToMany(mappedBy = "stars")
    private Set<Movie> movie;

    //Constructor
    public Star(){};
    public Star(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }
    //End const.

    //getters and setters


    public Set<Movie> getMovie() {
        return movie;
    }

    public void setMovie(Set<Movie> movie) {
        this.movie = movie;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    //end getters/s

    //Hahs

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Star star = (Star) o;

        return id != null ? id.equals(star.id) : star.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    //Hashend



}//endClass
