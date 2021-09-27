package com.dh.clinica.dto;

import com.dh.clinica.entity.Domicilio;
import com.dh.clinica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class DomicilioDTO implements Serializable {

    private Integer id;
    private String localidad;
    private String provincia;
    private String calle;
    private String numero;
    private Paciente paciente;

    public DomicilioDTO (){
   }
}
