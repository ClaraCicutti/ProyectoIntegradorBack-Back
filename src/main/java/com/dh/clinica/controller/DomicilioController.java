//package com.dh.clinica.controller;
//
//import com.dh.clinica.model.Domicilio;
//import com.dh.clinica.repository.impl.DomicilioDaoH2;
//import com.dh.clinica.service.DomicilioService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/domicilios")
//public class DomicilioController {
//
//    private DomicilioService domicilioService = new DomicilioService(new DomicilioDaoH2());
//
//    @PostMapping()
//    public ResponseEntity<Domicilio> registrarDomicilio(@RequestBody Domicilio domicilio) {
//
//        return ResponseEntity.ok(domicilioService.guardar(domicilio));
//
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Domicilio> buscar(@PathVariable Integer id) {
//        Domicilio domicilio = domicilioService.buscar(id).orElse(null);
//
//        return ResponseEntity.ok(domicilio);
//    }
//
////    @PutMapping()
////    public ResponseEntity<Domicilio> actualizar(@RequestBody Domicilio domicilio) {
////        ResponseEntity<Domicilio> response = null;
////
////        if (domicilio.getId() != null && domicilioService.buscar(domicilio.getId()).isPresent())
////            response = ResponseEntity.ok(domicilioService.actualizar(domicilio));
////        else
////            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
////
////        return response;
////    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
//        ResponseEntity<String> response = null;
//
//        if (domicilioService.buscar(id).isPresent()) {
//            domicilioService.eliminar(id);
//            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
//        } else {
//            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        return response;
//    }
//}