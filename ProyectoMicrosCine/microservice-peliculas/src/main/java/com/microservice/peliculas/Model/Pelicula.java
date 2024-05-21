package com.microservice.peliculas.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {

    private int id;
    private boolean estado;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;
    @NotEmpty
    private String director;
    @NotEmpty
    private String imagen;
    @NotEmpty
    private int duracion;
    @NotEmpty
    private String trailer;
    @NotEmpty
    private Date fechaRegistro;
    @NotEmpty
    private String usuarioRegistro;
    private Date fechaEliminacion;
    private String usuarioEliminacion;
    @NotEmpty
    private String categoriaPelicula;

}
