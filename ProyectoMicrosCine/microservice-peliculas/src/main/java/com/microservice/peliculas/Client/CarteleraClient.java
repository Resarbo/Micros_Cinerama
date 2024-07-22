package com.microservice.peliculas.Client;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.peliculas.Model.Pelicula;
import com.microservice.peliculas.Model.dto.CarteleraDTO;
import com.microservice.peliculas.Repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "msvc-cartelera", url = "localhost:9090/api/cartelera")
public interface CarteleraClient {

    @GetMapping("/pelicula/{idPelicula}")
    List<CarteleraDTO> findCarteleraByPelicula(@PathVariable int idPelicula);

   /* @GetMapping("/buscar-pelicula/{peliculaId}")
            List<CarteleraDTO> findCarteleraByPelicula(@PathVariable int idPelicula);
    @PostMapping("/cartelera")
    public CarteleraDTO save(@RequestBody CarteleraDTO Cartelera);

    @GetMapping("/cartelera/pelicula/{peliculaId}")
    public List<CarteleraDTO> getCartelera(@PathVariable("peliculaId") int perliculaId);*/



}
