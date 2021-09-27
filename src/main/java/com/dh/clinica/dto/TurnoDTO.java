package com.dh.clinica.dto;
import com.dh.clinica.entity.Odontologo;
import com.dh.clinica.entity.Paciente;
import com.dh.clinica.entity.Turno;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter
public class TurnoDTO implements Serializable{

    private Paciente paciente;
    private Odontologo odontologo;
    private Date fecha;

    public TurnoDTO (){
    }

}


