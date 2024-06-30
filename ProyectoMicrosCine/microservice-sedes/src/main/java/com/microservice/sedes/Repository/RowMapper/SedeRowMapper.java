package com.microservice.sedes.Repository.RowMapper;

import com.microservice.sedes.Model.Sede;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SedeRowMapper implements RowMapper<Sede> {

    @Override
    public Sede mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sede sede = new Sede();
        sede.setId(rs.getInt(1));
        sede.setNombre(rs.getString(2));
        sede.setDireccion(rs.getString(3));
        sede.setTelefono(rs.getString(4));

        return sede;
    }
}
