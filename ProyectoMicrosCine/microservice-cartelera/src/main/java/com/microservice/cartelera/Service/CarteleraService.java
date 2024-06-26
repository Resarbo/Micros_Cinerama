package com.microservice.cartelera.Service;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.cartelera.Model.dto.CarteleraHorarioDTO;
import com.microservice.cartelera.Model.dto.CarteleraPeliculaDTO;

import java.util.List;

public interface CarteleraService {
    Cartelera findById(int id);
    List<Cartelera> findAll();
    void save(Cartelera cartelera);
    void update(Cartelera cartelera);
    void deleteById(int id);
    List<CarteleraHorarioDTO> getCarteleraByHorario(int idHorario);

    List<CarteleraPeliculaDTO> findByIdPelicula(int idPelicula);
}
