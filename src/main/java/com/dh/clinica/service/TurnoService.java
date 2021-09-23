package com.dh.clinica.service;

import com.dh.clinica.entity.Paciente;
import com.dh.clinica.entity.Turno;
import com.dh.clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository repository;

    public Turno guardar(Turno turno){ return repository.save(turno); }

    public Turno buscar(Integer id){
        try{
            return repository.findById(id).get();
        }catch(NoSuchElementException exception){
            return null;
        }
    }

    public Turno actualizar(Turno turno){ return repository.save(turno); }

    public Boolean eliminar(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Turno> buscarTodos(){
        return repository.findAll();
    }
}
