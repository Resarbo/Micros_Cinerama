package com.microservice.cartelera.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sede {
    private int id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String direccion;
    @NotEmpty
    private String telefono;
}
