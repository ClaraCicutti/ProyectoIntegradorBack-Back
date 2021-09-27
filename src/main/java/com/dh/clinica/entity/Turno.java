package com.dh.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "turnos")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id", scope = Turno.class)
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Odontologo odontologo;

    private LocalDate date;

    public Turno() {
    }

    @Override
    public String toString() {
        return "Turno = " +
                "id: " + id +
                ", paciente: " + paciente +
                ", odontologo: " + odontologo +
                ", fecha: " + date
                ;
    }
}
