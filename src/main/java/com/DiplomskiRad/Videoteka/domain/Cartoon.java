package com.DiplomskiRad.Videoteka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cartoon")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany
    @JoinTable(name = "cartoon_creator", joinColumns = @JoinColumn(name = "cartoon_id"),
            inverseJoinColumns = @JoinColumn(name = "creator_id"))
    private Set<Creator> creators = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "cartoon_genre", joinColumns = @JoinColumn(name = "cartoon_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    public Cartoon(String name, int year, int seasons){
        this.name = name;
        this.year = year;
        this.seasons = seasons;
    }

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
