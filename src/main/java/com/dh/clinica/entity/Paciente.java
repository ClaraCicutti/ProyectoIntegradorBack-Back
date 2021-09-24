package com.dh.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Paciente.class)
@Getter @Setter
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Integer id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(unique = true, length = 12)
    private String dni;
    private Date fechaIngreso;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos;

    public Paciente() {
    }

    @Override
    public String toString() {
        return "Paciente= " +
                "id: " + id +
                ", nombre: " + nombre +
                ", apellido: " + apellido +
                ", dni: " + dni +
                ", fechaIngreso: " + fechaIngreso +
                ", domicilio: " + domicilio
                ;
    }
}
