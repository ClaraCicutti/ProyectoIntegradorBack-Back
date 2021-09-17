package com.dh.clinica.controller;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteGuardado = pacienteService.guardar(paciente);
        if(pacienteGuardado != null){
            return ResponseEntity.ok(pacienteGuardado);
        }else{
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id){
        Paciente pacienteBuscado = pacienteService.buscar(id);
        if (pacienteBuscado != null){
            return ResponseEntity.ok(pacienteBuscado);
        }else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;
        Paciente pacienteEncontrado = pacienteService.buscar(paciente.getId());
        if(pacienteEncontrado != null){
            return ResponseEntity.ok(pacienteService.actualizar(paciente));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        if (pacienteService.eliminar(id)){
            return ResponseEntity.ok("Paciente with id " + id + " was deleted");
        }
        return ResponseEntity.badRequest().body("Paciente with id " + id + " doesn't exist");
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
}