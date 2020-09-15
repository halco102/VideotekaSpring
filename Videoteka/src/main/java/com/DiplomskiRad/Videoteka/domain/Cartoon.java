package com.DiplomskiRad.Videoteka.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cartoon")
public class Cartoon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",unique = true)
    private String name;
    @Column(name = "year")
    private int year;
    @Column(name = "seasons")
    private int seasons;


    @JoinTable(name = "cartoon_creator", joinColumns = @JoinColumn(name = "cartoon_id"),
            inverseJoinColumns = @JoinColumn(name = "creator_id"))
    Set<Creator> creators = new HashSet<>();

    @JoinTable(name = "cartoon_genre", joinColumns = @JoinColumn(name = "cartoon_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    Set<Genre> genres = new HashSet<>();



    //Constructor
    public Cartoon(){};
    //end const

    //getters n setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    //end getters n setters

    //hash

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cartoon cartoon = (Cartoon) o;

        return id != null ? id.equals(cartoon.id) : cartoon.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    //end hash
}
