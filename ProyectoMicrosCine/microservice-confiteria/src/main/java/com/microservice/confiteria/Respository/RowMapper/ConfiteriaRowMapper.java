package com.microservice.confiteria.Respository.RowMapper;

import com.microservice.confiteria.Model.Confiteria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfiteriaRowMapper implements RowMapper<Confiteria> {
    @Override
    public Confiteria mapRow(ResultSet rs, int rowNum) throws SQLException {
       Confiteria confiteria = new Confiteria();

       confiteria.setId(rs.getInt(1));
       confiteria.setNombre(rs.getString(2));
       confiteria.setDescripcion(rs.getString(3));
       confiteria.setPrecio(rs.getDouble(4));
       confiteria.setStock(rs.getInt(5));
       confiteria.setImagen(rs.getString(6));

       return confiteria;
    }
}
