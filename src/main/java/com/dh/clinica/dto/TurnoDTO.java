package com.dh.clinica.dto;
import com.dh.clinica.entity.Odontologo;
import com.dh.clinica.entity.Paciente;
import com.dh.clinica.entity.Turno;
import java.io.Serializable;
import java.util.Date;

public class TurnoDTO implements Serializable{


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    private Paciente paciente;
    private Odontologo odontologo;
    private Date fecha;

        public TurnoDTO ( Turno turno){
            this.paciente= turno.getPaciente();
            this.odontologo= turno.getOdontologo();
            this.fecha= turno.getDate();

        }


    }


