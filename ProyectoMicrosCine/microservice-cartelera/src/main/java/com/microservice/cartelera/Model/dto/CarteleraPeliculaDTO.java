package com.microservice.cartelera.Model.dto;

import lombok.Data;

@Data

public class CarteleraPeliculaDTO {
    private int carteleraId;
    private double precio;
    private String peliculaNombre;
    private String sala;
    private String horario;
    private String sede;

}
