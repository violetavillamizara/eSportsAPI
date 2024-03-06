package com.eSports.web;

import com.eSports.domain.service.EquipoService;
import com.eSports.persistence.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin("*")
public class EquipoController {
    private final EquipoService equipoService;

    @Autowired
    public EquipoController(EquipoService equipoService) {this.equipoService = equipoService;}

    @GetMapping
    public List<Equipo> getAllEquipos(){return equipoService.getAllEquipos();}

    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable Long id){return equipoService.getEquipoById(id);}

    @PostMapping
    public Equipo addEquipo(@RequestBody Equipo equipo){return equipoService.addequipo(equipo);}

    @PutMapping
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo){
        Equipo updateEquipo = equipoService.updateEquipo(id, equipo);
        if(updateEquipo!= null){
            return new ResponseEntity<>(updateEquipo, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(updateEquipo, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id){equipoService.deleteEquipo(id);}
}
