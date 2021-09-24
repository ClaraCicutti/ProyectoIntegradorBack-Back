package com.dh.clinica.service;

import com.dh.clinica.controller.PacienteController;
import com.dh.clinica.dto.PacienteDTO;
import com.dh.clinica.entity.Paciente;
import com.dh.clinica.exception.BadRequestException;
import com.dh.clinica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PacienteService {

    final static Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private PacienteRepository repository;

    @Autowired
    ObjectMapper mapper;

    public Paciente guardar(PacienteDTO paciente) throws BadRequestException {
        if (paciente.getDni() == null || paciente.getNombre() == null || paciente.getApellido() == null)
            throw new BadRequestException("Te falta completar algún campo");
        Paciente pacienteNuevo = mapper.convertValue(paciente, Paciente.class);
        return repository.save(pacienteNuevo);
    }

    public PacienteDTO buscar(Integer id) throws BadRequestException {
        Optional<Paciente> pacienteBuscado = repository.findById(id);
        if (pacienteBuscado.isPresent())
            return mapper.convertValue(pacienteBuscado.get(), PacienteDTO.class);
        throw new BadRequestException("El paciente con id " + id + " no existe");
    }

    public Paciente actualizar(Paciente paciente) throws BadRequestException {
        if (buscar(paciente.getId()) == null) {
            throw new BadRequestException("No se puede actualizar porque el paciente con id " +
                    paciente.getId() + " no existe");
        }
        return repository.save(paciente);
    }

    public void eliminar(Integer id) throws BadRequestException {
        buscar(id);
        repository.deleteById(id);
    }

    public List<Paciente> buscarTodos() {
        return repository.findAll();
    }


//    public Paciente guardar(Paciente paciente){ return repository.save(paciente); }
//
//    public Paciente buscar(Integer id){
//        try{
//            return repository.findById(id).get();
//        }catch(NoSuchElementException exception){
//            return null;
//        }
//    }
//
//    public Paciente actualizar(Paciente paciente){ return repository.save(paciente); }
//
//    public Boolean eliminar(Integer id) {
//        if (repository.existsById(id)){
//            repository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//
//    public List<Paciente> buscarTodos(){
//        return repository.findAll();
//    }
}
