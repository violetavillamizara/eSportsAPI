package com.eSports.web;

import com.eSports.domain.service.JuegoService;
import com.eSports.persistence.Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
@CrossOrigin("*")
public class JuegoController {
    private final JuegoService juegoService;

    @Autowired
    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @GetMapping
    public List<Juego> getAllJuegos(){return juegoService.getAllJuegos();}

    @GetMapping("/{id}")
    public Juego getJuegoById(@PathVariable Long id){return juegoService.getJuegoById(id);}

    @PostMapping
    public Juego addjuego(@RequestBody Juego juego){return juegoService.addJuego(juego);}

    @PutMapping
    public ResponseEntity<Juego> updateJuego(@PathVariable Long id, @RequestBody Juego juego){
        Juego updateJuego = juegoService.updateJuego(id, juego);
        if(updateJuego!= null){
            return new ResponseEntity<>(updateJuego, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(updateJuego, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteJuego(@PathVariable Long id){juegoService.deleteJuego(id);}
}
