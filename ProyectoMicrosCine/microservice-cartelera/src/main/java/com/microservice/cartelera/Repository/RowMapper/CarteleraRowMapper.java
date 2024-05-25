package com.microservice.cartelera.Repository.RowMapper;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.peliculas.Model.Categoria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarteleraRowMapper implements RowMapper<Cartelera> {
    @Override
    public Cartelera mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cartelera cartelera = new Cartelera();

        return cartelera;
    }
}
