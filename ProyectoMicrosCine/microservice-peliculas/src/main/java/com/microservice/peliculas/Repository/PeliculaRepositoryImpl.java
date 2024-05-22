package com.microservice.peliculas.Repository;

import com.microservice.peliculas.Model.Pelicula;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaRepositoryImpl implements PeliculaRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Pelicula> rowMapper = new PeliculaRowMapper();

    public PeliculaRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Pelicula> findById(int id) {
        String sql = "SELECT * FROM peliculas WHERE id = ?";
        return jdbcTemplate.query(sql, rowMapper, id).stream().findFirst();
    }
    //holaaa
    @Override
    public List<Pelicula> findAll() {
        String sql = "SELECT * FROM Pelicula";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void save(Pelicula pelicula) {
        String sql = "INSERT INTO peliculas (nombre, descripcion, director, imagen, duracion, trailer, usuarioRegistro, categoriaPelicula) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        String sql = "UPDATE peliculas SET " +
                "nombre = ?, " +
                "descripcion = ?, " +
                "director = ?, " +
                "imagen = ?, " +
                "duracion = ?, " +
                "trailer = ?, " +
                "cUsuarioRegistro = ?, " +
                "categoriaPelicula = ? " +
                "WHERE id = ?";
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
        String sql = "DELETE FROM peliculas WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
