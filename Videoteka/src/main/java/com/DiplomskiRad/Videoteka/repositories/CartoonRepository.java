package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.Cartoon;
import org.springframework.data.repository.CrudRepository;

public interface CartoonRepository extends CrudRepository<Cartoon,Long> {
}
