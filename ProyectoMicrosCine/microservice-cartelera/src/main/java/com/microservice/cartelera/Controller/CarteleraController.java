package com.microservice.cartelera.Controller;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.cartelera.Service.CarteleraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cartelera")
public class CarteleraController {
    private final CarteleraService carteleraService;

    public CarteleraController(CarteleraService carteleraService) {
        this.carteleraService = carteleraService;
    }
    @GetMapping("/buscar-pelicula/{idPelicula}")
    public ResponseEntity<?> findCarteleraByPelicula(@PathVariable int idPelicula) {
        return ResponseEntity.ok(carteleraService.findCarteleraByPelicula(idPelicula));
    }
}
