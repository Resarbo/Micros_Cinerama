package com.microservice.cartelera.Service;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.cartelera.Model.dto.CarteleraHorarioDTO;
import com.microservice.cartelera.Model.dto.CarteleraPeliculaDTO;
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
    public Cartelera findById(int id) {
        return carteleraRepository.findById(id).orElseThrow(() -> new RuntimeException("Cartelera no disponible con ID: " + id));
    }

    @Override
    public List<Cartelera> findAll() {
        return carteleraRepository.findAll();
    }

    @Override
    public void save(Cartelera cartelera) {
        carteleraRepository.save(cartelera);
    }

    @Override
    public void update(Cartelera cartelera) {
        carteleraRepository.update(cartelera);
    }

    @Override
    public void deleteById(int id) {
        carteleraRepository.deleteById(id);
    }

    @Override
    public List<CarteleraHorarioDTO> getCarteleraByHorario(int idHorario) {
        return carteleraRepository.findCarteleraByHorario(idHorario);
    }

    @Override
    public List<CarteleraPeliculaDTO> byPelicula(int idPelicula) {
        return carteleraRepository.byPelicula(idPelicula);
    }

}
