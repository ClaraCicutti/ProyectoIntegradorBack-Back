package com.dh.clinica.controller;

import com.dh.clinica.model.Domicilio;
import com.dh.clinica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @PostMapping()
    public ResponseEntity<Domicilio> registrarDomicilio (@RequestBody Domicilio domicilio) {
        Domicilio domicilioGuardado = domicilioService.guardar(domicilio);
        if(domicilioGuardado != null){
            return ResponseEntity.ok(domicilioGuardado);
        }else{
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> buscar(@PathVariable Integer id) {
        try {
            Domicilio domicilioBuscado = domicilioService.buscar(id).get();
            return ResponseEntity.ok(domicilioBuscado);
        }catch (NoSuchElementException exception){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping()
    public ResponseEntity<Domicilio> actualizar(@RequestBody Domicilio domicilio) {
        ResponseEntity<Domicilio> response = null;
        try{
            domicilioService.buscar(domicilio.getId()).get();
            response = ResponseEntity.ok(domicilioService.actualizar(domicilio));
        }catch (NoSuchElementException exception){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (domicilioService.buscar(id).isPresent()) {
            domicilioService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Domicilio>> buscarTodos(){
        return ResponseEntity.ok(domicilioService.buscarTodos());
    }

}