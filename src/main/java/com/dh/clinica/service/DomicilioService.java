package com.dh.clinica.service;

import com.dh.clinica.model.Domicilio;
import com.dh.clinica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

    @Autowired
    private DomicilioRepository repository;

    public Domicilio guardar(Domicilio domicilio){ return repository.save(domicilio); }

    public Optional <Domicilio> buscar(Integer id){ return repository.findById(id); }

    public Domicilio actualizar(Domicilio domicilio){ return repository.save(domicilio); }

    public void eliminar(Integer id){ repository.deleteById(id); }

    public List<Domicilio> buscarTodos(){
        return repository.findAll();
    }

}
