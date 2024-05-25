package com.microservice.cartelera.Service;

import com.microservice.cartelera.Model.Cartelera;

import java.util.List;

public interface CarteleraService {
    List<Cartelera> findCarteleraByPelicula(int idPelicula);
}
