package com.eSports.domain.service;

import com.eSports.domain.repository.PartidaRepository;
import com.eSports.persistence.Partida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaServiceImpl implements PartidaService{
    private final PartidaRepository partidaRepository;

    @Autowired
    public PartidaServiceImpl(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    @Override
    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }

    @Override
    public Partida getPartidaById(Long id) {
        Optional<Partida> optionalPartida = partidaRepository.findById(id);
        return optionalPartida.orElse(null);
    }

    @Override
    public Partida addPartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    @Override
    public Partida updatePartida(Long id, Partida newPartida) {
        return partidaRepository.findById(id)
                .map(partida -> {
                    partida.setPuntuacion(newPartida.getPuntuacion());
                    partida.setJuego(newPartida.getJuego());
                    partida.setJugador(newPartida.getJugador());
                    partida.setFecha(newPartida.getFecha());
                    return partidaRepository.save(partida);
                }).orElse(null);
    }

    @Override
    public void deletePartida(Long id) {
        partidaRepository.deleteById(id);
    }


    public List<Partida> obtenerPartidasPorJugador(Long jugadorId) {
        return partidaRepository.findAllPartidasByJugadorId(jugadorId);
    }

    public Integer obtenerMaxPuntuacionPorJuego(Long juegoId) {
        return partidaRepository.findMaxPuntuacionByJuegoId(juegoId);
}}
