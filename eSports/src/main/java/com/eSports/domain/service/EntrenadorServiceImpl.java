package com.eSports.domain.service;

import com.eSports.domain.repository.EntrenadorRepository;
import com.eSports.persistence.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorServiceImpl implements EntrenadorService{

    private final EntrenadorRepository entrenadorRepository;

    @Autowired
    public EntrenadorServiceImpl(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    @Override
    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    @Override
    public Entrenador getEntrenadorById(Long id) {
        Optional<Entrenador> optionalEntrenador = entrenadorRepository.findById(id);
        return optionalEntrenador.orElse(null);
    }

    @Override
    public Entrenador addEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    @Override
    public Entrenador updateEntrenador(Long id, Entrenador newEntrenador) {
        return entrenadorRepository.findById(id)
        .map(entrenador->{
            entrenador.setNombre(newEntrenador.getNombre());
            entrenador.setExperienciaYears(newEntrenador.getExperienciaYears());
            entrenador.setEquipo(newEntrenador.getEquipo());
            return entrenadorRepository.save(entrenador);
        }) .orElse(null);
    }

    @Override
    public void deleteEntrenador(Long id) {
            entrenadorRepository.deleteById(id);
    }
}
