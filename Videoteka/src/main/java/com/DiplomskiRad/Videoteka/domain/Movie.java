package com.DiplomskiRad.Videoteka.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",unique = true)
    @NotBlank(message = "Title can not be blank!")
    @Size(min=2 , max = 40, message = "Title must be between 2 and 40")
    private String name;

    @Column(name = "year")
    @Min(value = 1940,message = "Min year value is 1940")
    private int year;

    @Column(name = "runtime")
    @Min(value=10,message = "Min runtime value is 10 min")
    private int runtime;

    @ManyToMany
    @JoinTable(name = "movie_genre", joinColumns =
    @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"))
    Set<Genre> genres = new HashSet<>();

    @ManyToMany
    @JoinTable(name="movie_star",joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "star_id"))
    Set<Star>stars = new HashSet<>();

    //Constructors
        public Movie(){};
        public Movie(String name,int year,int runtime){
            this.name=name;
            this.year=year;
            this.runtime=runtime;
        }
    //end Constructor

    //Getters n setters


    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Star> getStars() {
        return stars;
    }

    public void setStars(Set<Star> stars) {
        this.stars = stars;
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

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    //End Getters n setters

    //Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return id != null ? id.equals(movie.id) : movie.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    //endHash
}
