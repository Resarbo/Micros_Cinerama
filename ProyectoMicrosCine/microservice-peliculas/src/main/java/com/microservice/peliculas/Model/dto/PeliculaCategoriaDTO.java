package com.microservice.peliculas.Model.dto;

import lombok.Data;

@Data
public class PeliculaCategoriaDTO {
    private int peliculaId;
    private String peliculaNombre;
    private String peliculaDescripcion;
    private String peliculaDirector;
    private String peliculaImagen;
    private String categoriaNombre;
}
