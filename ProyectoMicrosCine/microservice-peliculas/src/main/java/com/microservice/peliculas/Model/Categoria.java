package com.microservice.peliculas.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    private int id;
    private boolean estado;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private int tipo;
    @NotEmpty
    private Date fechaRegistro;
    @NotEmpty
    private String usuarioRegistro;
    private Date fechaEliminacion;
    private String usuarioEliminacion;
}
