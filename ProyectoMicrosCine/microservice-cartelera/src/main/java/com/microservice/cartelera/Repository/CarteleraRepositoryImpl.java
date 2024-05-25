package com.microservice.cartelera.Repository;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.cartelera.Repository.RowMapper.CarteleraRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarteleraRepositoryImpl implements CarteleraRepository{
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Cartelera> rowMapperCartelera = new CarteleraRowMapper();

    public CarteleraRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Cartelera> findCarteleraByPelicula(int idPelicula) {
        String sql = "select c.nID, c.bEstado, c.mPrecio, p.cNombre, c.nIDSala, h.cInicio\n" +
                "from Cartelera c\n" +
                "inner join Pelicula p on p.nID = c.nIDPelicula \n" +
                "inner join Horario h on h.nID = c.nIDHorario\n" +
                "where c.bEstado = 1 and c.nIDPelicula = ?";
        return jdbcTemplate.query(sql, new Object[]{idPelicula}, (rs, rowNum) -> {
            Cartelera dto = new Cartelera();
            dto.setId(rs.getInt("nID"));
            dto.setEstado(rs.getBoolean("bEstado"));
            dto.setPrecio(rs.getFloat("mPrecio"));
            dto.setPelicula(rs.getString("cNombre"));
            dto.setSala(rs.getString("nIDSala"));
            dto.setHorario(rs.getString("cInicio"));
            return dto;
        });
    }
}
