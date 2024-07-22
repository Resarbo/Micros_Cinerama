package com.microservice.cartelera.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala {
    private int id;
    private boolean estado;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private int filas;
    @NotEmpty
    private int columnas;
    @NotEmpty
    private int capacidad;
    @NotEmpty
    private int tipo;
    @NotEmpty
    private String usuarioRegistro;
    @NotEmpty
    private Date fechaRegistro;
    private Date fechaEliminacion;
    private String usuarioEliminacion;
    private String categoriaSala;
}
