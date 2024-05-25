package com.microservice.cartelera.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cartelera {
    private int id;
    private boolean estado;
    @NotEmpty
    private Date fechaRegistro;
    @NotEmpty
    private String usuarioRegistro;
    private float precio;
    private Date fechaEliminacion;
    private String usuarioEliminacion;
    @NotEmpty
    private String pelicula;
    @NotEmpty
    private String sala;
    @NotEmpty
    private String horario;
    private int idPelicula;
}