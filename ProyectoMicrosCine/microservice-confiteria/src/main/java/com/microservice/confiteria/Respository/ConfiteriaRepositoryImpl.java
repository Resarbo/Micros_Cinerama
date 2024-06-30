package com.microservice.confiteria.Respository;

import com.microservice.confiteria.Model.Confiteria;
import com.microservice.confiteria.Respository.RowMapper.ConfiteriaRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ConfiteriaRepositoryImpl implements ConfiteriaRepository{

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Confiteria> rowMapperConfitera = new ConfiteriaRowMapper();


    public ConfiteriaRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Confiteria> findById(int id) {
        String sql = StoredProceduresC.SEL_CONFITERIA_ID;
        return jdbcTemplate.query(sql, rowMapperConfitera, id).stream().findFirst();
    }

    @Override
    public List<Confiteria> findAll() {
        String sql = StoredProceduresC.SEL_CONFITERIA;
        return jdbcTemplate.query(sql, rowMapperConfitera);
    }

    @Override
    public void save(Confiteria confiteria) {
        String sql = StoredProceduresC.INS_CONFITERIA;
        jdbcTemplate.update(sql,
                confiteria.getNombre(),
                confiteria.getDescripcion(),
                confiteria.getPrecio(),
                confiteria.getStock(),
                confiteria.getImagen());
    }

    @Override
    public void update(Confiteria confiteria) {
        String sql = StoredProceduresC.UPD_CONFITERIA;
        jdbcTemplate.update(sql,
                confiteria.getNombre(),
                confiteria.getDescripcion(),
                confiteria.getPrecio(),
                confiteria.getStock(),
                confiteria.getImagen(),
                confiteria.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = StoredProceduresC.DEL_CONFITERIA;
        jdbcTemplate.update(sql, id);
    }
}
