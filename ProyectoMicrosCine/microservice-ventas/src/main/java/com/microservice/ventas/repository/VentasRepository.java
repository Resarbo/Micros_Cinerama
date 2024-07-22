package com.microservice.ventas.repository;

import com.microservice.ventas.entities.Venta;

public interface VentasRepository {
    void save(Venta venta);
}
