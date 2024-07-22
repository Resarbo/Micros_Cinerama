package com.microservice.ventas.repository;

import com.microservice.ventas.entities.DetalleVenta;
import com.microservice.ventas.entities.Venta;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VentasRepositoryImpl implements VentasRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall insertarVentaJdbcCall;

    @PostConstruct
    public void init() {
        insertarVentaJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("InsertarVenta")
                .declareParameters(
                        new SqlParameter("nCantidad", Types.INTEGER),
                        new SqlParameter("nIDCartelera", Types.INTEGER),
                        new SqlOutParameter("idVenta", Types.INTEGER)
                );
    }

    public void save(Venta venta) {
        // Llamar al procedimiento almacenado para insertar la venta
        Map<String, Object> ventaParams = new HashMap<>();
        ventaParams.put("nCantidad", venta.getCantidadVenta());
        ventaParams.put("nIDCartelera", venta.getIdCartelera());

        Map<String, Object> result = insertarVentaJdbcCall.execute(ventaParams);
        Integer idVenta = (Integer) result.get("idVenta");

        // Insertar cada detalle de venta directamente
        String detalleVentaSql = "INSERT INTO DetalleVenta (bEstado, nCantidad, mPrecio, nIdAsiento, nIdVenta, dtFechaRegistro, cUsuarioRegistro, nIDSede) VALUES (1, ?, ?, ?, ?, GETDATE(), 'CFTM', ?)";

        for (DetalleVenta detalle : venta.getDetalleVenta()) {
            jdbcTemplate.update(detalleVentaSql,
                    detalle.getCantidad(),
                    detalle.getPrecio(),
                    detalle.getIdAsiento(),
                    idVenta,
                    detalle.getIdSede());
        }
    }

}
