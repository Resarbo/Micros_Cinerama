package com.microservice.ventas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    private byte cantidadVenta;
    private Integer idCartelera;
    private List<DetalleVenta> detalleVenta;
}
