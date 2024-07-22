package com.microservice.sedes.Repository;

import com.microservice.sedes.Model.Sede;

import java.util.List;
import java.util.Optional;

public interface SedeRepository {
    Optional<Sede> findById(int id);

    List<Sede> findAll();

    void save(Sede sede);

    void update(Sede sede);

    void deleteById(int id);

}
