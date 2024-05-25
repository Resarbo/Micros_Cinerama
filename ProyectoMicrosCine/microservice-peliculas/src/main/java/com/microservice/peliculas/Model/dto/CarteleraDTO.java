package com.microservice.peliculas.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarteleraDTO {
    private int peliculaId;

    private boolean estado;
    private float precio;
    private String peliculaNombre;
    private String sala;
    private String horario;
}
