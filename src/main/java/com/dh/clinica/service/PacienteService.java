package com.dh.clinica.service;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente guardar(Paciente paciente){ return repository.save(paciente); }

    public Paciente buscar(Integer id){
        try{
            return repository.findById(id).get();
        }catch(NoSuchElementException exception){
            return null;
        }
    }

    public Paciente actualizar(Paciente paciente){ return repository.save(paciente); }

    public Boolean eliminar(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Paciente> buscarTodos(){
        return repository.findAll();
    }
}
