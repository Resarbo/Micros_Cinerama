package com.microservice.peliculas.Repository.RowMapper;

import com.microservice.peliculas.Model.Pelicula;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeliculaRowMapper implements RowMapper<Pelicula> {
    @Override
    public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(rs.getInt(1));
        pelicula.setEstado(rs.getBoolean(2));
        pelicula.setNombre(rs.getString(3));
        pelicula.setDescripcion(rs.getString(4));
        pelicula.setDirector(rs.getString(5));
        pelicula.setImagen(rs.getString(6));
        pelicula.setDuracion(rs.getInt(7));
        pelicula.setTrailer(rs.getString(8));
        pelicula.setCategoriaPelicula(rs.getString(9));
        return pelicula;
    }
}
