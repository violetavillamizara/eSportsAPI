package com.eSports.domain.repository;

import com.eSports.persistence.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
    @Query("SELECT p FROM Partida p WHERE p.jugador.id = :jugadorId")
    List<Partida> findAllPartidasByJugadorId(@Param("jugadorId") Long jugadorId);

    @Query("SELECT MAX(p.puntuacion) FROM Partida p WHERE p.juego.id = :juegoId")
    Integer findMaxPuntuacionByJuegoId(@Param("juegoId") Long juegoId);

}
