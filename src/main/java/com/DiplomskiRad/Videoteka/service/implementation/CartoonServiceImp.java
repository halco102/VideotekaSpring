package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Cartoon;
import com.DiplomskiRad.Videoteka.dto.CartoonDto;
import com.DiplomskiRad.Videoteka.mapper.CartoonMapper;
import com.DiplomskiRad.Videoteka.repositories.CartoonRepository;
import com.DiplomskiRad.Videoteka.service.CartoonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartoonServiceImp implements CartoonService {


    private final CartoonRepository cartoonRepository;
    private final CartoonMapper cartoonMapper;

    public CartoonServiceImp(CartoonRepository cartoonRepository, CartoonMapper cartoonMapper) {
        this.cartoonRepository = cartoonRepository;
        this.cartoonMapper = cartoonMapper;
    }

    @Override
    public CartoonDto findCartoonById(Long id) {
       return cartoonMapper.toDto(cartoonRepository.findById(id).get());
    }

    @Override
    public List<CartoonDto> getAllCartoonGenres() {

        return this.cartoonRepository.getAllCartoonGenres().stream().map(cartoonMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CartoonDto> findAllCartoons() {
        return cartoonRepository.findAll().stream().map(cartoonMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCartoonById(Long id) {
        cartoonRepository.deleteById(id);
    }

    @Override
    public List<CartoonDto> findByKeyword(String keyword) {
        if(keyword!=null){
            return this.cartoonRepository.findByKeyword(keyword).stream().map(cartoonMapper::toDto).collect(Collectors.toList());
        }
        else {
            return this.cartoonRepository.findAll().stream().map(cartoonMapper::toDto).collect(Collectors.toList());
        }

    }

    @Override
    public void addCartoon(CartoonDto cartoon) {
        Cartoon temp = cartoonMapper.toEntity(cartoon);
        this.cartoonRepository.save(temp);
    }

    @Override
    public List<CartoonDto> listOfSeriesOnGenre(String searchGenre) {
        return this.cartoonRepository.listOfCartoonsOnGenre(searchGenre).stream().map(cartoonMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CartoonDto> searchEngine(String searchGenre, String keyword) {
        if(keyword!=null && searchGenre == null){
            return this.cartoonRepository.findByKeyword(keyword).stream().map(cartoonMapper::toDto).collect(Collectors.toList());
        }
        else if(keyword==null && searchGenre!=null){
            return this.cartoonRepository.listOfCartoonsOnGenre(searchGenre).stream().map(cartoonMapper::toDto).collect(Collectors.toList());
        }
        return this.cartoonRepository.findAll().stream().map(cartoonMapper::toDto).collect(Collectors.toList());
    }
}
