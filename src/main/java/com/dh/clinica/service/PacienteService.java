package com.dh.clinica.service;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente guardar(Paciente paciente){ return repository.save(paciente); }

    public Optional <Paciente> buscar(Integer id){ return repository.findById(id); }

    public Paciente actualizar(Paciente paciente){ return repository.save(paciente); }

    public void eliminar(Integer id){ repository.deleteById(id); }

    public List<Paciente> buscarTodos(){
        return repository.findAll();
    }
}
