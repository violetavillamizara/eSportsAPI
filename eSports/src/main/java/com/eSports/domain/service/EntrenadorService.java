package com.eSports.domain.service;

import com.eSports.persistence.Entrenador;

import java.util.List;

public interface EntrenadorService {
    List<Entrenador> getAllEntrenadores();
    Entrenador getEntrenadorById(Long id);
    Entrenador addEntrenador(Entrenador entrenador);
    Entrenador updateEntrenador(Long id, Entrenador entrenador);
    void deleteEntrenador(Long id);
}
