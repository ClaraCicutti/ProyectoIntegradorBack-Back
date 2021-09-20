package com.dh.clinica.service;

import com.dh.clinica.entity.Odontologo;
import com.dh.clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository repository;

    public Odontologo guardar(Odontologo odontologo){ return repository.save(odontologo); }

    public Odontologo buscar(Integer id){
        try{
            return repository.findById(id).get();
        }catch(NoSuchElementException exception){
            return null;
        }
    }

    public Odontologo actualizar(Odontologo odontologo){ return repository.save(odontologo); }

    public Boolean eliminar(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Odontologo> buscarTodos(){
        return repository.findAll();
    }
}
