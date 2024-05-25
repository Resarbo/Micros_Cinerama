package com.microservice.cartelera.Repository;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.cartelera.Model.Horario;
import com.microservice.cartelera.Model.dto.CarteleraHorarioDTO;
import com.microservice.cartelera.Repository.RowMapper.CarteleraRowMapper;
import com.microservice.cartelera.Repository.RowMapper.HorarioRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarteleraRepositoryImpl implements CarteleraRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Cartelera> rowMapperCartelera = new CarteleraRowMapper();
    private final RowMapper<Horario> rowMapperHorario = new HorarioRowMapper();

    public CarteleraRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Optional<Cartelera> findById(int id) {
        String sql = "{call Sel_Cartelera_ID(?)}";
        return jdbcTemplate.query(sql, rowMapperCartelera, id).stream().findFirst();
    }

    @Override
    public List<Cartelera> findAll() {
        String sql = "SELECT * FROM Cartelera";
        return jdbcTemplate.query(sql, rowMapperCartelera);
    }

    @Override
    public void save(Cartelera cartelera) {
        String sql = "INSERT INTO";
        jdbcTemplate.update(sql,
                cartelera.getFechaRegistro(),
                cartelera.getPrecio(),
                cartelera.getUsuarioRegistro(),
                cartelera.getPelicula(),
                cartelera.getSala(),
                cartelera.getHorario());
    }

    @Override
    public void update(Cartelera cartelera) {
        String sql = "UPDATE ";
        jdbcTemplate.update(sql,
                cartelera.getFechaRegistro(),
                cartelera.getPrecio(),
                cartelera.getUsuarioRegistro(),
                cartelera.getPelicula(),
                cartelera.getSala(),
                cartelera.getHorario(),
                cartelera.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<CarteleraHorarioDTO> findCarteleraByHorario(int idHorario) {
        return null;
    }
}
