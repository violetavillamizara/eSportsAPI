package com.eSports.domain.service;

import com.eSports.domain.repository.JugadorRepository;
import com.eSports.persistence.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements JugadorService{
    private final JugadorRepository jugadorepository;

    @Autowired
    public JugadorServiceImpl(JugadorRepository jugadorepository) {
        this.jugadorepository = jugadorepository;
    }

    @Override
    public List<Jugador> getAllJugadores() {
        return jugadorepository.findAll();
    }

    @Override
    public Jugador getJugadorById(Long id) {
        Optional<Jugador> optionalJugador = jugadorepository.findById(id);
        return optionalJugador.orElse(null);

    }

    @Override
    public Jugador addJugador(Jugador jugador) {
        return jugadorepository.save(jugador);
    }

    @Override
    public Jugador updateJugador(Long id, Jugador newJugador) {
        return jugadorepository.findById(id)
                .map(jugador -> {
                    jugador.setNombre(newJugador.getNombre());
                    jugador.setFechaNacimiento(newJugador.getFechaNacimiento());
                    jugador.setEquipo(newJugador.getEquipo());
                    return jugadorepository.save(jugador);
                }).orElse(null);
    }

    @Override
    public void deleteJugador(Long id) {
        jugadorepository.deleteById(id);
    }
}
