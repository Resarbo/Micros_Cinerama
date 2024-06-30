package com.microservice.sedes.Service;

import com.microservice.sedes.Model.Sede;
import com.microservice.sedes.Repository.SedeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements SedeService {

    private final SedeRepository sedeRepository;

    public SedeServiceImpl(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    @Override
    public Sede findById(int id) {
        return sedeRepository.findById(id).orElseThrow(()-> new RuntimeException("Sede no disponible con ID: " + id));
    }

    @Override
    public List<Sede> findAll() {
        return sedeRepository.findAll();
    }

    @Override
    public void save(Sede sede) {
        sedeRepository.save(sede);
    }

    @Override
    public void update(Sede sede) {
        sedeRepository.update(sede);
    }

    @Override
    public void deleteById(int id) {
        sedeRepository.deleteById(id);
    }
}
