package com.microservice.cartelera.Repository.RowMapper;

import com.microservice.cartelera.Model.Cartelera;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarteleraRowMapper implements RowMapper<Cartelera> {
    @Override
    public Cartelera mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cartelera cartelera = new Cartelera();

        cartelera.setId(rs.getInt(1));
        cartelera.setEstado(rs.getBoolean(2));
        cartelera.setFechaRegistro(rs.getDate(3));
        cartelera.setPrecio(rs.getDouble(4));
        cartelera.setUsuarioRegistro(rs.getString(5));
        cartelera.setFechaEliminacion(rs.getDate(6));
        cartelera.setUsuarioEliminacion(rs.getString(7));
        cartelera.setPelicula(rs.getString(8));
        cartelera.setSala(rs.getString(9));
        cartelera.setHorario(rs.getString(10));

        return cartelera;
    }
}
