package com.eSports.web;

import com.eSports.domain.service.EntrenadorService;
import com.eSports.persistence.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@CrossOrigin("*")
public class EntrenadorController {
    private final EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService) {this.entrenadorService = entrenadorService;}

    @GetMapping
    public List<Entrenador> getAllEntrenadores() {return entrenadorService.getAllEntrenadores();}

    @GetMapping("/{id}")
    public Entrenador getEntrenadorById(@PathVariable Long id) {return entrenadorService.getEntrenadorById(id);}

    @PostMapping
    public Entrenador addEntrenador(@RequestBody Entrenador entrenador) {return entrenadorService.addEntrenador(entrenador);}

    @PutMapping("/update/{id} ")
    public ResponseEntity<Entrenador> updateEntrenador(@PathVariable Long id, @RequestBody Entrenador entrenador){
        Entrenador updateEntrenador = entrenadorService.updateEntrenador(id, entrenador);
        if(updateEntrenador!= null){
            return new ResponseEntity<>(updateEntrenador, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(updateEntrenador, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEntrenador(@PathVariable Long id) {entrenadorService.deleteEntrenador(id);}
}
