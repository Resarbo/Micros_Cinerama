package com.microservice.peliculas.Controller;

import com.microservice.peliculas.Model.Pelicula;
import com.microservice.peliculas.Model.dto.CarteleraDTO;
import com.microservice.peliculas.Service.PeliculaService;
import com.microservice.peliculas.Model.dto.PeliculaCategoriaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable int id) {
        Pelicula pelicula = peliculaService.findById(id);
        return ResponseEntity.ok(pelicula);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Pelicula>> getAllPeliculas() {
        List<Pelicula> peliculas = peliculaService.findAll();
        return ResponseEntity.ok(peliculas);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> createPelicula(@RequestBody Pelicula pelicula) {
        peliculaService.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/guardar/{id}")
    public ResponseEntity<Void> updatePelicula(@PathVariable int id, @RequestBody Pelicula pelicula) {
        pelicula.setId(id);
        peliculaService.update(pelicula);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable int id) {
        peliculaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<PeliculaCategoriaDTO>> getPeliculasByCategoria(@PathVariable int idCategoria) {
        List<PeliculaCategoriaDTO> peliculasByCategoria = peliculaService.getPeliculasByCategoria(idCategoria);
        return ResponseEntity.ok(peliculasByCategoria);
    }

    @GetMapping("/cartelera/{idCartelera}")
    public ResponseEntity<List<?>> getPeliculasByCartelera() {
        return ResponseEntity.ok(peliculaService.findAll());
    }

    @GetMapping("/search-cartelera/{idPelicula}")
    public ResponseEntity<?> findCarteleraByPelicula(@PathVariable int idPelicula){
        return ResponseEntity.ok(peliculaService.findCarteleraByPelicula(idPelicula));
    }

}
