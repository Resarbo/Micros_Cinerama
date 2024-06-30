package com.microservice.sedes.Service;

import com.microservice.sedes.Model.Sede;

import java.util.List;

public interface SedeService {
    Sede findById(int id);
    List<Sede> findAll();
    void save(Sede sede);
    void update(Sede sede);
    void deleteById(int id);
}
