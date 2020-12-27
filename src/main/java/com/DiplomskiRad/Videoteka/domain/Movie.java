package com.DiplomskiRad.Videoteka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",unique = true)
    private String name;
    @Column(name = "year")
    private int year;
    @Column(name = "runtime")
    private int runtime;

    @ManyToMany
    @JoinTable(name = "movie_genre", joinColumns =
    @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"))
    Set<Genre> genres = new HashSet<>();

    @ManyToMany
    @JoinTable(name="movie_star",joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "star_id"))
    Set<Star>stars = new HashSet<>();

        public Movie(String name,int year,int runtime){
            this.name=name;
            this.year=year;
            this.runtime=runtime;
        }


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
