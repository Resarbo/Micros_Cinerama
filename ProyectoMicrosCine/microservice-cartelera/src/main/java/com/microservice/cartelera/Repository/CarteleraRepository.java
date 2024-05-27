package com.microservice.cartelera.Repository;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.cartelera.Model.dto.CarteleraHorarioDTO;
import com.microservice.cartelera.Model.dto.CarteleraPeliculaDTO;

import java.util.List;
import java.util.Optional;

public interface CarteleraRepository {
    Optional<Cartelera> findById(int id);

    List<Cartelera> findAll();

    void save(Cartelera cartelera);

    void update(Cartelera cartelera);

    void deleteById(int id);

    List<CarteleraHorarioDTO> findCarteleraByHorario(int idHorario);

    List<CarteleraPeliculaDTO> byPelicula(int idPelicula);

    // List<CarteleraPeliculaDTO> byPelicula(int idPelicula);

}
