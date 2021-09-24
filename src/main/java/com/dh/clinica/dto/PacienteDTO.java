package com.dh.clinica.dto;
import com.dh.clinica.entity.Domicilio;
import com.dh.clinica.entity.Paciente;
import com.dh.clinica.entity.Turno;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter @Setter
public class PacienteDTO implements Serializable {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private Date fechaIngreso;
    private Domicilio domicilio;
    private Set<Turno> turnos;

    public PacienteDTO (){
    }

}
