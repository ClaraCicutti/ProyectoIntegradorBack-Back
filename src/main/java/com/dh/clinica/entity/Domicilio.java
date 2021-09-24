package com.dh.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "domicilios")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Domicilio.class)
public class Domicilio {

    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    @OneToOne(mappedBy = "domicilio")
    private Paciente paciente;

    public Domicilio() {
    }

    @Override
    public String toString() {
        return "Domicilio " +
                "id: " + id +
                ", calle: " + calle +
                ", numero: " + numero +
                ", localidad: " + localidad +
                ", provincia: " + provincia;
    }
}
