package com.dh.clinica.controller;

import com.dh.clinica.entity.Paciente;
import com.dh.clinica.entity.Turno;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
@CrossOrigin("*")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping()
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        Turno turnoGuardado = turnoService.guardar(turno);
        if(turnoGuardado != null){
            return ResponseEntity.ok(turnoGuardado);
        }else{
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Integer id){
        Turno turnoBuscado = turnoService.buscar(id);
        if (turnoBuscado != null){
            return ResponseEntity.ok(turnoBuscado);
        }else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping()
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) {
        ResponseEntity<Turno> response = null;
        Turno turnoEcontrado = turnoService.buscar(turno.getId());
        if(turnoEcontrado != null){
            return ResponseEntity.ok(turnoService.actualizar(turno));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        if (turnoService.eliminar(id)){
            return ResponseEntity.ok("Turno with id " + id + " was deleted");
        }
        return ResponseEntity.badRequest().body("Turno with id " + id + " doesn't exist");
    }

    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }
}
