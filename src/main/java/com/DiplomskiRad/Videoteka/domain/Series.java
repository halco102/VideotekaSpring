package com.DiplomskiRad.Videoteka.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "series")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Series {

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

    @ManyToMany
    @JoinTable(name = "series_star", joinColumns = @JoinColumn(name = "series_id"),
    inverseJoinColumns = @JoinColumn(name = "star_id"))
    private Set<Star> stars = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "series_genre", joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    public Series(String name,int year,int seasons){
            this.name=name;
            this.year=year;
            this.seasons=seasons;
    }

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
