package com.microservice.peliculas.Repository;

import com.microservice.peliculas.Model.Pelicula;
import com.microservice.peliculas.Model.dto.PeliculaCategoriaDTO;

import java.util.List;
import java.util.Optional;

public interface PeliculaRepository {
    Optional<Pelicula> findById(int id);
    List<Pelicula> findAll();
    void save(Pelicula pelicula);
    void update(Pelicula pelicula);
    void deleteById(int id);
    List<PeliculaCategoriaDTO> findPeliculasByCategoria(int idCategoria);
    
}
