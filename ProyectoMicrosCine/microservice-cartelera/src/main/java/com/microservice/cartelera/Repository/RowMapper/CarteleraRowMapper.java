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
        cartelera.setPrecio(rs.getDouble(2));
        cartelera.setId_pelicula(rs.getString(3));
        cartelera.setSala(rs.getString(4));
        cartelera.setHorario(rs.getString(5));
        cartelera.setSede(rs.getString(6));

        return cartelera;
    }
}
