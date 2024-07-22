package com.microservice.cartelera.Model.dto;

import lombok.Data;

@Data
public class CarteleraHorarioDTO {
    private int carteleraId;
    private double carteleraPrecio;
    private String carteleraPelicula;
    private String carteleraSala;
    private String carteleraHorario;
    private String carteleraSede;
}
