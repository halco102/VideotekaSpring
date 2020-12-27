package com.DiplomskiRad.Videoteka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "creator")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Creator {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Creator(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }


    //hash
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creator creator = (Creator) o;

        return id != null ? id.equals(creator.id) : creator.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    //end hash
}
