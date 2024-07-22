package com.microservice.confiteria.Service;

import com.microservice.confiteria.Model.Confiteria;
import com.microservice.confiteria.Respository.ConfiteriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiteriaServiceImpl implements ConfiteriaService{

    private final ConfiteriaRepository confiteriaRepository;

    public ConfiteriaServiceImpl(ConfiteriaRepository confiteriaRepository) {
        this.confiteriaRepository = confiteriaRepository;
    }


    @Override
    public Confiteria findById(int id) {
        return confiteriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Confiteria no disponible con ID: " + id));
    }

    @Override
    public List<Confiteria> findAll() {
        return confiteriaRepository.findAll();
    }

    @Override
    public void save(Confiteria confiteria) {
        confiteriaRepository.save(confiteria);
    }

    @Override
    public void update(Confiteria confiteria) {
        confiteriaRepository.update(confiteria);
    }

    @Override
    public void deleteById(int id) {
        confiteriaRepository.deleteById(id);
    }
}
