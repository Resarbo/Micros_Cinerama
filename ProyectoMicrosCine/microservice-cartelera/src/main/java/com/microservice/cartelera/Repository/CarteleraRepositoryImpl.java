package com.microservice.cartelera.Repository;

import com.microservice.cartelera.Model.Cartelera;
import com.microservice.cartelera.Model.Horario;
import com.microservice.cartelera.Model.dto.CarteleraHorarioDTO;
import com.microservice.cartelera.Model.dto.CarteleraPeliculaDTO;
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

    public CarteleraRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Cartelera> findById(int id) {
        //String sql = "{call Sel_Cartelera_ID(?)}";
        String sql = StoredProceduresC.SEL_CARTELERA_ID;
        return jdbcTemplate.query(sql, rowMapperCartelera, id).stream().findFirst();
    }

    @Override
    public List<Cartelera> findAll() {
        String sql = StoredProceduresC.SEL_CARTELERA;
        return jdbcTemplate.query(sql, rowMapperCartelera);
    }

    @Override
    public void save(Cartelera cartelera) {
        String sql = StoredProceduresC.INS_CARTELERA;
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
        String sql = StoredProceduresC.UPD_CARTELERA;
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
        String sql = StoredProceduresC.DEL_CARTELERA;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<CarteleraHorarioDTO> findCarteleraByHorario(int idHorario) {
        String sql = StoredProceduresC.SEL_CARTELERABYHORARIO_ID;
        return jdbcTemplate.query(sql, new Object[]{idHorario}, (rs, rowNum) -> {
            CarteleraHorarioDTO dto = new CarteleraHorarioDTO();
            dto.setCarteleraId(rs.getInt("cartelera_id"));
            dto.setCarteleraPrecio(rs.getDouble("cartelera_precio"));
            dto.setCarteleraPelicula(rs.getString("cartelera_pelicula"));
            dto.setCarteleraHorario(rs.getString("cartelera_horario"));
            return dto;
        });
    }

   @Override
    public List<CarteleraPeliculaDTO> byPelicula(int idPelicula) {
       String sql = "";
       return jdbcTemplate.query(sql, new Object[]{idPelicula}, (rs, rowNum) -> {
           CarteleraPeliculaDTO dto = new CarteleraPeliculaDTO();
           dto.setCarteleraId(rs.getInt("cartelera_id"));
           dto.setPrecio(rs.getDouble("precio"));
           dto.setPeliculaNombre(rs.getString("pelicula_nombre"));
           dto.setSala(rs.getString("sala"));
           dto.setHorario(rs.getString("horario"));
           return dto;
       });
    }


}

