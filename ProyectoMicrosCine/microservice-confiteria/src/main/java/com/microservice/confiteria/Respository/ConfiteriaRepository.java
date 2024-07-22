package com.microservice.confiteria.Respository;

import com.microservice.confiteria.Model.Confiteria;

import java.util.List;
import java.util.Optional;

public interface ConfiteriaRepository {
    Optional<Confiteria> findById(int id);

    List<Confiteria> findAll();

    void save(Confiteria confiteria);

    void update(Confiteria confiteria);

    void deleteById(int id);
}
