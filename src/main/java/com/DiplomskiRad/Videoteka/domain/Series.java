package com.DiplomskiRad.Videoteka.domain;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min=2,max = 40,message = "Title has to be 2 or 40 characters long")
    @Column(name = "name",unique = true)
    private String name;


    @Column(name = "year")
    @Min(value = 1940,message = "Min year is 1940")
    @Max(value = 2021,message = "Max year is 2021")
    private int year;

    @Column(name = "seasons")
    @Min(value = 1,message = "Min number of seasons is 1")
    private int seasons;

    @ManyToMany
    @JoinTable(name = "series_star", joinColumns = @JoinColumn(name = "series_id"),
    inverseJoinColumns = @JoinColumn(name = "star_id"))
    Set<Star> stars = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "series_genre", joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    Set<Genre> genres = new HashSet<>();



    //Constructor
        public Series(){};
        public Series(String name,int year,int seasons){
            this.name=name;
            this.year=year;
            this.seasons=seasons;
        }
    //End Constructor

    //getters n setters


    public Set<Star> getStars() {
        return stars;
    }

    public void setStars(Set<Star> stars) {
        this.stars = stars;
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

        Series series = (Series) o;

        return id != null ? id.equals(series.id) : series.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    //end hash

}
