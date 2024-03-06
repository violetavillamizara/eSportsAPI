package com.eSports.domain.service;

import com.eSports.domain.repository.JuegoRepository;
import com.eSports.persistence.Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuegoServiceImpl implements JuegoService{
    private final JuegoRepository juegoRepository;

    @Autowired
    public JuegoServiceImpl(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @Override
    public List<Juego> getAllJuegos() {
        return juegoRepository.findAll();
    }

    @Override
    public Juego getJuegoById(Long id) {
        Optional<Juego> optionaljuego = juegoRepository.findById(id);
        return optionaljuego.orElse(null);
    }

    @Override
    public Juego addJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    @Override
    public Juego updateJuego(Long id, Juego newJuego) {
        return juegoRepository.findById(id)
                .map(juego -> {
                    juego.setNombre(newJuego.getNombre());
                    juego.setPlataforma(newJuego.getPlataforma());
                    juego.setPartidas(newJuego.getPartidas());
                    return juegoRepository.save(juego);
                }).orElse(null);
    }

    @Override
    public void deleteJuego(Long id) {
        juegoRepository.deleteById(id);
    }
}
