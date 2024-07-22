package com.microservice.peliculas.Service;

import com.microservice.peliculas.Client.CarteleraClient;
import com.microservice.peliculas.Model.Pelicula;
import com.microservice.peliculas.Model.dto.CarteleraDTO;
import com.microservice.peliculas.Model.dto.PeliculaCategoriaDTO;
import com.microservice.peliculas.Repository.PeliculaRepository;
import com.microservice.peliculas.http.response.CarteleraByPeliculaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService{
    private final PeliculaRepository peliculaRepository;

    @Autowired
    private CarteleraClient carteleraClient;

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

    @Override
    public CarteleraByPeliculaResponse findCarteleraByPelicula(int idPelicula) {
        //Consultar la pelicula
        Pelicula pelicula = peliculaRepository.findById(idPelicula).orElse(new Pelicula());

        //Obtener la cartelera
        List<CarteleraDTO> carteleraDTOList = carteleraClient.findCarteleraByPelicula(idPelicula);
        return CarteleraByPeliculaResponse.builder()
                .peliculaNombre(pelicula.getNombre())
                .duracion(pelicula.getDuracion())
                .carteleraDTOList(carteleraDTOList)
                .build();
    }



    /*public CarteleraDTO saveCartelera(int peliculaId, CarteleraDTO cartelera) {
        cartelera.setPeliculaId(peliculaId);
        Cartelera nuevoCartelera = CarteleraClient.saveCartelera();
        return nuevoCartelera;
    }*/
}
