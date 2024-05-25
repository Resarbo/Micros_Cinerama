package com.microservice.peliculas.Repository.RowMapper;

import com.microservice.peliculas.Model.Categoria;
import com.microservice.peliculas.Model.Pelicula;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaRowMapper implements RowMapper<Categoria> {
    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt(1));
        categoria.setEstado(rs.getBoolean(2));
        categoria.setNombre(rs.getString(3));
        categoria.setTipo(rs.getInt(4));
        categoria.setFechaRegistro(rs.getDate(5));
        categoria.setUsuarioRegistro(rs.getString(6));
        categoria.setFechaEliminacion(rs.getDate(7));
        categoria.setUsuarioEliminacion(rs.getString(8));
        return categoria;
    }
}
