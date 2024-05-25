package com.microservice.peliculas.Service;

import com.microservice.peliculas.Model.Pelicula;
import com.microservice.peliculas.Model.dto.PeliculaCategoriaDTO;

import java.util.List;

public interface PeliculaService {
    Pelicula findById(int id);
    List<Pelicula> findAll();
    void save(Pelicula pelicula);
    void update(Pelicula pelicula);
    void deleteById(int id);
    List<PeliculaCategoriaDTO> getPeliculasByCategoria(int idCategoria);

}
