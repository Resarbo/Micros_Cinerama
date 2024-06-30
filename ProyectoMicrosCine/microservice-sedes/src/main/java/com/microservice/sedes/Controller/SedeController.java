package com.microservice.sedes.Controller;

import com.microservice.sedes.Model.Sede;
import com.microservice.sedes.Service.SedeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class SedeController {

    private final SedeService sedeService;

    public SedeController(SedeService sedeService) {
        this.sedeService = sedeService;
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Sede> getSedeById(@PathVariable int id){
      Sede sede = sedeService.findById(id);
        return ResponseEntity.ok(sede);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Sede>> getAllSede() {
        List<Sede> sede = sedeService.findAll();
        return ResponseEntity.ok(sede);
    }
    @PostMapping("/guardar")
    public ResponseEntity<Void> createSede(@RequestBody Sede sede) {
        sedeService.save(sede);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/guardar/{id}")
    public ResponseEntity<Void> updateSede(@PathVariable int id, @RequestBody Sede sede) {
        sede.setId(id);
        sedeService.update(sede);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteSede(@PathVariable int id) {
        sedeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
