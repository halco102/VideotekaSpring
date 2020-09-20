package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Cartoon;
import com.DiplomskiRad.Videoteka.repositories.CartoonRepository;
import com.DiplomskiRad.Videoteka.service.implementation.CartoonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartoonServiceImp implements CartoonService {


    private final CartoonRepository cartoonRepository;

    public CartoonServiceImp(CartoonRepository cartoonRepository) {
        this.cartoonRepository = cartoonRepository;
    }

    @Override
    public Cartoon findCartoonById(Long id) {
        return cartoonRepository.findById(id).get();
    }

    @Override
    public List<Cartoon> findAllCartoons() {
        return cartoonRepository.findAll();
    }

    @Override
    public void deleteCartoonById(Long id) {
        cartoonRepository.deleteById(id);
    }

    @Override
    public List<Cartoon> findByKeyword(String keyword) {
        return cartoonRepository.findByKeyword(keyword);
    }
}
