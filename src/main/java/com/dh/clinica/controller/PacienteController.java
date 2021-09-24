package com.dh.clinica.controller;

import com.dh.clinica.dto.PacienteDTO;
import com.dh.clinica.entity.Paciente;
import com.dh.clinica.exception.BadRequestException;
import com.dh.clinica.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

    final static Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody PacienteDTO paciente) throws BadRequestException {
        Paciente pacienteGuardado = pacienteService.guardar(paciente);
        return ResponseEntity.ok(pacienteGuardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Integer id) throws BadRequestException{
        PacienteDTO pacienteBuscado = pacienteService.buscar(id);
        logger.debug("Se encontró el paciente con id " + id);
        return ResponseEntity.ok(pacienteBuscado);
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) throws BadRequestException {
        Paciente pacienteActualizado = pacienteService.actualizar(paciente);
        return ResponseEntity.ok(pacienteActualizado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) throws BadRequestException {
        pacienteService.eliminar(id);
        return ResponseEntity.ok("Paciente with id " + id + " doesn't exist");
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

//    @PostMapping()
//    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
//        Paciente pacienteGuardado = pacienteService.guardar(paciente);
//        if(pacienteGuardado != null){
//            return ResponseEntity.ok(pacienteGuardado);
//        }else{
//            return ResponseEntity.internalServerError().body(null);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Paciente> buscar(@PathVariable Integer id){
//        Paciente pacienteBuscado = pacienteService.buscar(id);
//        if (pacienteBuscado != null){
//            return ResponseEntity.ok(pacienteBuscado);
//        }else {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    @PutMapping()
//    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
//        ResponseEntity<Paciente> response = null;
//        Paciente pacienteEncontrado = pacienteService.buscar(paciente.getId());
//        if(pacienteEncontrado != null){
//            return ResponseEntity.ok(pacienteService.actualizar(paciente));
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity eliminar(@PathVariable Integer id) {
//        if (pacienteService.eliminar(id)){
//            return ResponseEntity.ok("Paciente with id " + id + " was deleted");
//        }
//        return ResponseEntity.badRequest().body("Paciente with id " + id + " doesn't exist");
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Paciente>> buscarTodos(){
//        return ResponseEntity.ok(pacienteService.buscarTodos());
//    }
}