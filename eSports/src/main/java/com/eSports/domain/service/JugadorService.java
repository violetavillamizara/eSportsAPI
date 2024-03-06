package com.eSports.domain.service;

import com.eSports.persistence.Jugador;

import java.util.List;

public interface JugadorService {
    List<Jugador> getAllJugadores();

    Jugador getJugadorById(Long id);

    Jugador addJugador(Jugador jugador);

    Jugador updateJugador(Long id, Jugador jugador);

    void deleteJugador(Long id);
}
