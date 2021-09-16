package com.dh.clinica.service;

//import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository repository;

    public Odontologo save(Odontologo o){ return repository.save(o); }

    public Optional <Odontologo> buscar(Integer id){ return repository.findById(id); }

    public Odontologo actualizar(Odontologo odontologo){ return repository.save(odontologo); }

    public List<Odontologo> buscarTodos(){
        return repository.findAll();
    }
}
