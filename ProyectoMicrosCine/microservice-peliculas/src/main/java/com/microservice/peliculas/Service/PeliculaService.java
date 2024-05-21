package com.microservice.peliculas.Service;

import com.microservice.peliculas.Model.Pelicula;

import java.util.List;

public interface PeliculaService {
    Pelicula findById(int id);
    List<Pelicula> findAll();
    void save(Pelicula pelicula);
    void update(Pelicula pelicula);
    void deleteById(int id);
}
