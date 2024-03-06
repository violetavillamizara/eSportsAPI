package com.eSports.domain.service;

import com.eSports.persistence.Equipo;

import java.util.List;

public interface EquipoService {
    List<Equipo> getAllEquipos();
    Equipo getEquipoById(Long id);
    Equipo addequipo(Equipo equipo);
    Equipo updateEquipo(Long id, Equipo equipo);
    void deleteEquipo(Long id);
}
