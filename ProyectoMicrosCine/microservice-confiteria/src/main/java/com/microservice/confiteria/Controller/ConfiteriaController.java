package com.microservice.confiteria.Controller;

import com.microservice.confiteria.Model.Confiteria;
import com.microservice.confiteria.Service.ConfiteriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/confiteria")
public class ConfiteriaController {

    private final ConfiteriaService confiteriaService;

    public ConfiteriaController(ConfiteriaService confiteriaService) {
        this.confiteriaService = confiteriaService;
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Confiteria> getConfiteriaById(@PathVariable int id){
        Confiteria confiteria = confiteriaService.findById(id);
        return ResponseEntity.ok(confiteria);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Confiteria>> getAllConfiteria() {
        List<Confiteria> confiteria = confiteriaService.findAll();
        return ResponseEntity.ok(confiteria);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> createConfiteria(@RequestBody Confiteria confiteria) {
        confiteriaService.save(confiteria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/guardar/{id}")
    public ResponseEntity<Void> updateConfiteria(@PathVariable int id, @RequestBody Confiteria confiteria) {
        confiteria.setId(id);
        confiteriaService.update(confiteria);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteConfiteria(@PathVariable int id) {
        confiteriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
