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
    public List<Cartoon> getAllCartoonGenres() {
        return cartoonRepository.getAllCartoonGenres();
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
        if(keyword!=null){
            return this.cartoonRepository.findByKeyword(keyword);
        }
        if(keyword==null){
            return this.cartoonRepository.findAll();
        }

        return this.cartoonRepository.getAllCartoonGenres();


    }

    @Override
    public void addCartoon(Cartoon cartoon) {
        this.cartoonRepository.save(cartoon);
    }

    @Override
    public List<Cartoon> listOfSeriesOnGenre(String searchGenre) {
        return this.cartoonRepository.listOfCartoonsOnGenre(searchGenre);
    }

    @Override
    public List<Cartoon> searchEngine(String searchGenre, String keyword) {
        if(keyword!=null && searchGenre == null){
            return this.cartoonRepository.findByKeyword(keyword);
        }
        else if(keyword==null && searchGenre!=null){
            return this.cartoonRepository.listOfCartoonsOnGenre(searchGenre);
        }
        return this.cartoonRepository.findAll();
    }
}
