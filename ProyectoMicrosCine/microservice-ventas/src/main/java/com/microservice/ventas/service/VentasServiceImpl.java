package com.microservice.ventas.service;

import com.microservice.ventas.entities.Venta;
import com.microservice.ventas.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasServiceImpl implements VentasService{
    @Autowired
    private VentasRepository ventaRepository;

    public void save(Venta venta) {
        ventaRepository.save(venta);
    }
}
