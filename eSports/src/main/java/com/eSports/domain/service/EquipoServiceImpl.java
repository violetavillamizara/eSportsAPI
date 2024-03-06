package com.eSports.domain.service;

import com.eSports.domain.repository.EquipoRepository;
import com.eSports.persistence.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements EquipoService{

    private final EquipoRepository equipoRepository;

    @Autowired
    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo getEquipoById(Long id) {
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);
        return optionalEquipo.orElse(null);
    }

    @Override
    public Equipo addequipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo updateEquipo(Long id, Equipo newEquipo) {
        return equipoRepository.findById(id)
                .map(equipo->{
                    equipo.setNombre(newEquipo.getNombre());
                    equipo.setPatrocinador(newEquipo.getPatrocinador());
                    equipo.setEntrenador(newEquipo.getEntrenador());
                    equipo.setJugadores(newEquipo.getJugadores());
                    return equipoRepository.save(equipo);
                }) .orElse(null);
    }

    @Override
    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
}
