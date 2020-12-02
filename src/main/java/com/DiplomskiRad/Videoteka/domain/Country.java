package com.DiplomskiRad.Videoteka.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name",unique = true)
    String countryName;

    @OneToMany(mappedBy = "country")
    Set<Creator> creatorSet;

    //constructor
    public Country(){};

    public Country(String countryName){
        this.countryName=countryName;
    }
    //end counstructor

    //getter and setters


    public Set<Creator> getCreatorSet() {
        return creatorSet;
    }

    public void setCreatorSet(Set<Creator> creatorSet) {
        this.creatorSet = creatorSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    //end getter and setters


    //hascode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return id != null ? id.equals(country.id) : country.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    //end hashcode


}
