package com.eSports.domain.service;

import com.eSports.persistence.Juego;

import java.util.List;

public interface JuegoService {

    List<Juego> getAllJuegos();

    Juego getJuegoById(Long id);

    Juego addJuego(Juego juego);

    Juego updateJuego(Long id, Juego juego);

    void deleteJuego(Long id);

}
