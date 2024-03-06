package com.eSports.domain.service;

import com.eSports.persistence.Partida;

import java.util.List;

public interface PartidaService {
    List<Partida> getAllPartidas();

    Partida getPartidaById(Long id);

    Partida addPartida(Partida partida);

    Partida updatePartida(Long id, Partida partida);

    void deletePartida(Long id);

    List<Partida> obtenerPartidasPorJugador(Long jugadorId);

    Integer obtenerMaxPuntuacionPorJuego(Long juegoId);
}
