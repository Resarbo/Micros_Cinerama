package com.microservice.cartelera.Service;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.cartelera.Repository.CarteleraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteleraServiceImpl implements CarteleraService{
    private final CarteleraRepository carteleraRepository;

    public CarteleraServiceImpl(CarteleraRepository carteleraRepository) {
        this.carteleraRepository = carteleraRepository;
    }

    @Override
    public List<Cartelera> findCarteleraByPelicula(int idCategoria) {
        return carteleraRepository.findCarteleraByPelicula(idCategoria);
    }
}
