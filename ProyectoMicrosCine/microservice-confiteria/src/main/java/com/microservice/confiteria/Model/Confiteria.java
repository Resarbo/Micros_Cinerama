package com.microservice.confiteria.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Confiteria {
    private int id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;
    @NotEmpty
    private double precio;
    @NotEmpty
    private int stock;
    @NotEmpty
    private String imagen;
}
