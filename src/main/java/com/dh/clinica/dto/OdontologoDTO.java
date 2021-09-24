package com.dh.clinica.dto;

import com.dh.clinica.entity.Odontologo;
import com.dh.clinica.entity.Paciente;
import com.dh.clinica.entity.Turno;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter @Setter
public class OdontologoDTO implements Serializable {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;
    private Set<Turno> turnos;

    public OdontologoDTO (){
    }

}
