package com.microservice.cartelera.Repository.RowMapper;

import com.microservice.cartelera.Model.Sala;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaRowMapper implements RowMapper<Sala> {
    @Override
    public Sala mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sala sala = new Sala();
        sala.setId(rs.getInt(1));
        sala.setEstado(rs.getBoolean(2));
        sala.setNombre(rs.getString(3));
        sala.setFilas(rs.getInt(4));
        sala.setColumnas(rs.getInt(5));
        sala.setCapacidad(rs.getInt(6));
        sala.setTipo(rs.getInt(7));
        sala.setUsuarioRegistro(rs.getString(8));
        sala.setFechaRegistro(rs.getDate(9));
        sala.setFechaEliminacion(rs.getDate(10));
        sala.setUsuarioEliminacion(rs.getString(11));
        sala.setCategoriaSala(rs.getString(12));

        return sala;
    }
}
