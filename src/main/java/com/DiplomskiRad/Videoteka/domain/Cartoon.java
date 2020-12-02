package com.DiplomskiRad.Videoteka.domain;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @Size(min = 2,max=40,message = "Title has to be between 2 and 40 characters long")
    private String name;

    @Min(value = 1940,message = "Min year is 1940")
    @Max(value = 2021,message = "Max year is 2021")
    @Column(name = "year")
    private int year;

    @Min(value = 1,message = "Min number of seasons is 1")
    @Column(name = "seasons")
    private int seasons;

    @ManyToMany
    @JoinTable(name = "cartoon_creator", joinColumns = @JoinColumn(name = "cartoon_id"),
            inverseJoinColumns = @JoinColumn(name = "creator_id"))
    Set<Creator> creators = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "cartoon_genre", joinColumns = @JoinColumn(name = "cartoon_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    Set<Genre> genres = new HashSet<>();


    //Constructor
    public Cartoon(){};
    //end const

    public Cartoon(String name,int year,int seasons) {
        this.name = name;
        this.year = year;
        this.seasons = seasons;
    }

    //getters n setters


    public Set<Creator> getCreators() {
        return creators;
    }

    public void setCreators(Set<Creator> creators) {
        this.creators = creators;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

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
