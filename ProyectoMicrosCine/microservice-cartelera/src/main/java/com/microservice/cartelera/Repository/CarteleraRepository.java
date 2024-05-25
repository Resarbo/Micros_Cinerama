package com.microservice.cartelera.Repository;

import com.microservice.cartelera.Model.Cartelera;

import java.util.List;

public interface CarteleraRepository {
    List<Cartelera> findCarteleraByPelicula(int idPelicula);

}
