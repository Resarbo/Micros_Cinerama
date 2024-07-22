package com.microservice.sedes.Repository;

import com.microservice.sedes.Model.Sede;
import com.microservice.sedes.Repository.RowMapper.SedeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SedeRepositoryImpl implements SedeRepository{

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Sede> rowMapperSede = new SedeRowMapper();

    public SedeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Sede> findById(int id) {
        String sql = StoredProceduresC.SEL_SEDE_ID;
        return jdbcTemplate.query(sql, rowMapperSede, id).stream().findFirst();
    }

    @Override
    public List<Sede> findAll() {
        String sql = StoredProceduresC.SEL_SEDE;
        return jdbcTemplate.query(sql, rowMapperSede);
    }

    @Override
    public void save(Sede sede) {
        String sql = StoredProceduresC.INS_SEDE;
        jdbcTemplate.update(sql,
                sede.getNombre(),
                sede.getDireccion(),
                sede.getTelefono());
    }

    @Override
    public void update(Sede sede) {
        String sql = StoredProceduresC.UPD_SEDE;
        jdbcTemplate.update(sql,
                sede.getNombre(),
                sede.getDireccion(),
                sede.getTelefono(),
                sede.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = StoredProceduresC.DEL_SEDE;
        jdbcTemplate.update(sql, id);
    }
}
