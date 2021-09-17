package com.dh.clinica.controller;

import com.dh.clinica.model.Odontologo;

import com.dh.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/odontologos")
@CrossOrigin("*")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {
        Odontologo odontologoGuardado = odontologoService.guardar(odontologo);
        if(odontologoGuardado != null){
            return ResponseEntity.ok(odontologoGuardado);
        }else{
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Integer id){
        Odontologo odontologoBuscado = odontologoService.buscar(id);
        if (odontologoBuscado != null){
            return ResponseEntity.ok(odontologoBuscado);
        }else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response = null;
        Odontologo odontologoEncontrado = odontologoService.buscar(odontologo.getId());
        if(odontologoEncontrado != null){
            return ResponseEntity.ok(odontologoService.actualizar(odontologo));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        if (odontologoService.eliminar(id)){
            return ResponseEntity.ok("Odontologo with id " + id + " was deleted");
        }
        return ResponseEntity.badRequest().body("Odontologo with id " + id + " doesn't exist");
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

}
