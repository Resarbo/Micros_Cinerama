package com.microservice.peliculas.Service;

import com.microservice.peliculas.Model.Pelicula;
import com.microservice.peliculas.Model.dto.PeliculaCategoriaDTO;
import com.microservice.peliculas.Repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService{
    private final PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }
    @Override
    public Pelicula findById(int id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrada con ID: " + id));
    }

    @Override
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    @Override
    public void save(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public void update(Pelicula pelicula) {
        peliculaRepository.update(pelicula);
    }

    @Override
    public void deleteById(int id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public List<PeliculaCategoriaDTO> getPeliculasByCategoria(int idCategoria) {
        return peliculaRepository.findPeliculasByCategoria(idCategoria);
    }
}
