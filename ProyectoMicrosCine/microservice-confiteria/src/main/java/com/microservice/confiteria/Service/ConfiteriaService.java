package com.microservice.confiteria.Service;

import com.microservice.confiteria.Model.Confiteria;

import java.util.List;

public interface ConfiteriaService {
    Confiteria findById(int id);
    List<Confiteria> findAll();
    void save(Confiteria confiteria);
    void update(Confiteria confiteria);
    void deleteById(int id);
}
