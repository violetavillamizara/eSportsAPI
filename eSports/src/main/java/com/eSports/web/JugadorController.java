package com.eSports.web;

import com.eSports.domain.service.JugadorService;
import com.eSports.persistence.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin("*")
public class JugadorController {
    private final JugadorService jugadorService;

    @Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public List<Jugador> getAllJugadores(){return jugadorService.getAllJugadores();}

    @GetMapping("/{id}")
    public Jugador getJugadorById(@PathVariable Long id){return jugadorService.getJugadorById(id);}

    @PostMapping
    public Jugador addJugador(@RequestBody Jugador jugador){return jugadorService.addJugador(jugador);}

    @PutMapping
    public ResponseEntity<Jugador> updateJugador(@PathVariable Long id, @RequestBody Jugador jugador){
        Jugador updateJugador = jugadorService.updateJugador(id, jugador);
        if(updateJugador!= null){
            return new ResponseEntity<>(updateJugador, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(updateJugador, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id){jugadorService.deleteJugador(id);}
}
