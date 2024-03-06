package com.eSports.web;

import com.eSports.domain.service.PartidaService;
import com.eSports.persistence.Partida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidas")
@CrossOrigin("*")
public class PartidaController {
    private final PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public List<Partida> getAllPartidas(){return partidaService.getAllPartidas();}

    @GetMapping("/{id}")
    public Partida getPartidaById(@PathVariable Long id){return partidaService.getPartidaById(id);}

    @PostMapping
    public Partida addPartidas(@RequestBody Partida partida){return partidaService.addPartida(partida);}

    @PutMapping
    public ResponseEntity<Partida> updatePartida(@PathVariable Long id, @RequestBody Partida partida){
        Partida updatePartida = partidaService.updatePartida(id, partida);
        if(updatePartida!= null){
            return new ResponseEntity<>(updatePartida, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(updatePartida, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePartida(@PathVariable Long id){partidaService.deletePartida(id);}

    @GetMapping("/jugador/{jugadorId}")
    public List<Partida> obtenerPartidasPorJugador(@PathVariable Long jugadorId) {
        return partidaService.obtenerPartidasPorJugador(jugadorId);
    }

    @GetMapping("/puntuacionMaxima/{juegoId}")
    public Integer obtenerMaxPuntuacionPorJuego(@PathVariable Long juegoId) {
        return partidaService.obtenerMaxPuntuacionPorJuego(juegoId);
}}
