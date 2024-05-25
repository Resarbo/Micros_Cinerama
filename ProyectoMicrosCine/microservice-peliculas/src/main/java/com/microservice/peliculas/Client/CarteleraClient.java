package com.microservice.peliculas.Client;

import com.microservice.peliculas.Model.dto.CarteleraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-cartelera", url = "localhost:9090/api/cartelera")
public interface CarteleraClient {
    @GetMapping("/buscar-pelicula/{idPelicula}")
    List<CarteleraDTO> findCarteleraByPelicula(@PathVariable int idPelicula);
}
