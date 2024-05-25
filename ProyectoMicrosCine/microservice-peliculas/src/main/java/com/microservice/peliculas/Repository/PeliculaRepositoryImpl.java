package com.microservice.peliculas.Repository;

import com.microservice.peliculas.Model.Categoria;
import com.microservice.peliculas.Model.Pelicula;
import com.microservice.peliculas.Model.dto.PeliculaCategoriaDTO;
import com.microservice.peliculas.Repository.RowMapper.CategoriaRowMapper;
import com.microservice.peliculas.Repository.RowMapper.PeliculaRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaRepositoryImpl implements PeliculaRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Pelicula> rowMapperPelicula = new PeliculaRowMapper();
    private final RowMapper<Categoria> rowMapperCategoria = new CategoriaRowMapper();

    public PeliculaRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Pelicula> findById(int id) {
        String sql = "{call Sel_Peliculas_ID(?)}";
        return jdbcTemplate.query(sql, rowMapperPelicula, id).stream().findFirst();
    }
    //holaaa
    @Override
    public List<Pelicula> findAll() {
        String sql = "SELECT * FROM Pelicula";
        return jdbcTemplate.query(sql, rowMapperPelicula);
    }

    @Override
    public void save(Pelicula pelicula) {
        String sql = "INSERT INTO Pelicula (cNombre, cDescripcion, cDirector, cImagen, nDuracion, nIDTrailer, cUsuarioRegistro, nIDCategoria) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                pelicula.getNombre(),
                pelicula.getDescripcion(),
                pelicula.getDirector(),
                pelicula.getImagen(),
                pelicula.getDuracion(),
                pelicula.getTrailer(),
                pelicula.getUsuarioRegistro(),
                pelicula.getCategoriaPelicula());
    }

    @Override
    public void update(Pelicula pelicula) {
        String sql = "UPDATE Pelicula SET " +
                "cNombre = ?, " +
                "cDescripcion = ?, " +
                "cDirector = ?, " +
                "cImagen = ?, " +
                "nDuracion = ?, " +
                "nIDTrailer = ?, " +
                "cUsuarioRegistro = ?, " +
                "nIDCategoria = ? " +
                "WHERE nID = ?";
        jdbcTemplate.update(sql,
                pelicula.getNombre(),
                pelicula.getDescripcion(),
                pelicula.getDirector(),
                pelicula.getImagen(),
                pelicula.getDuracion(),
                pelicula.getTrailer(),
                pelicula.getUsuarioRegistro(),
                pelicula.getCategoriaPelicula(),
                pelicula.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM Pelicula WHERE nID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<PeliculaCategoriaDTO> findPeliculasByCategoria(int idCategoria) {
        String sql = "SELECT p.nID as pelicula_id, p.cNombre as pelicula_nombre, p.cDescripcion as pelicula_descripcion, "
                + "p.cDirector as pelicula_director, p.cImagen as pelicula_imagen, p.nDuracion as pelicula_duracion, "
                + "p.nIDTrailer as pelicula_trailer, c.cNombre as categoria_nombre "
                + "FROM Pelicula p JOIN CategoriaPelicula c ON p.nIDCategoria = c.nID "
                + "WHERE c.nID = ?";
        return jdbcTemplate.query(sql, new Object[]{idCategoria}, (rs, rowNum) -> {
            PeliculaCategoriaDTO dto = new PeliculaCategoriaDTO();
            dto.setPeliculaId(rs.getInt("pelicula_id"));
            dto.setPeliculaNombre(rs.getString("pelicula_nombre"));
            dto.setPeliculaDescripcion(rs.getString("pelicula_descripcion"));
            dto.setPeliculaDirector(rs.getString("pelicula_director"));
            dto.setPeliculaImagen(rs.getString("pelicula_imagen"));
            dto.setPeliculaDuracion(rs.getInt("pelicula_duracion"));
            dto.setPeliculaTrailer(rs.getString("pelicula_trailer"));
            dto.setCategoriaNombre(rs.getString("categoria_nombre"));
            return dto;
        });
    }
}
