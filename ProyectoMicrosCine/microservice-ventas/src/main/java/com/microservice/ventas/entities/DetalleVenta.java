package com.microservice.ventas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {
    private byte cantidad;
    private double precio;
    private int idAsiento;
    private Integer idSede;
}
