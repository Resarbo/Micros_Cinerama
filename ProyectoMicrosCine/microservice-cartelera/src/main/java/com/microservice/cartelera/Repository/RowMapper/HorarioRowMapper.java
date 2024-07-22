package com.microservice.cartelera.Repository.RowMapper;

import com.microservice.cartelera.Model.Horario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HorarioRowMapper implements RowMapper<Horario> {
    @Override
    public Horario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Horario horario = new Horario();
        horario.setId(rs.getInt(1));
        horario.setEstado(rs.getBoolean(2));
        horario.setInicio(rs.getString(3));
        horario.setTipo(rs.getInt(4));
        horario.setFechaRegistro(rs.getDate(5));
        horario.setUsuarioRegistro(rs.getString(6));
        horario.setFechaEliminacion(rs.getDate(7));
        horario.setUsuarioEliminacion(rs.getString(8));
        return horario;
    }
}
