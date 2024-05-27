package com.microservice.cartelera.Controller;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.cartelera.Model.dto.CarteleraHorarioDTO;
import com.microservice.cartelera.Model.dto.CarteleraPeliculaDTO;
import com.microservice.cartelera.Service.CarteleraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartelera")
public class CarteleraController {

    private final CarteleraService carteleraService;

    public CarteleraController(CarteleraService carteleraService) {
        this.carteleraService = carteleraService;
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Cartelera> getCarteleraById(@PathVariable int id){
        Cartelera cartelera = carteleraService.findById(id);
        return ResponseEntity.ok(cartelera);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cartelera>> getAllCartelera() {
        List<Cartelera> cartelera = carteleraService.findAll();
        return ResponseEntity.ok(cartelera);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> createCartelera(@RequestBody Cartelera cartelera) {
        carteleraService.save(cartelera);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/guardar/{id}")
    public ResponseEntity<Void> updateCartelera(@PathVariable int id, @RequestBody Cartelera cartelera) {
        cartelera.setId(id);
        carteleraService.update(cartelera);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteCartelera(@PathVariable int id) {
        carteleraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/horario/{idHorario}")
    public ResponseEntity<List<CarteleraHorarioDTO>> getCarteleraByHorario(@PathVariable int idHorario) {
        List<CarteleraHorarioDTO> carteleraByHorario = carteleraService.getCarteleraByHorario(idHorario);
        return ResponseEntity.ok(carteleraByHorario);
    }

    @GetMapping("/pelicula/{peliculaId}")
    public ResponseEntity<List<CarteleraPeliculaDTO>> listarCarteleraPorPeliculaId(@PathVariable("idPelicula") int idPelicula){
        List<CarteleraPeliculaDTO> cartelera = carteleraService.byPelicula(idPelicula);
        if(cartelera.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cartelera);
    }
}

