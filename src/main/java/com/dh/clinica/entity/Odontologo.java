package com.dh.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "odontologos")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Odontologo.class)
public class Odontologo {

    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Integer id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(unique = true, length = 18)
    private Integer matricula;

    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnos;


//    CORREGIR TODA ESTA PARTE!!
//    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.REMOVE)
//    private Set<Paciente> pacientes = new HashSet<>();

    //    //    Prueba con lo que estaba en playground
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Paciente paciente;

    public Odontologo(){}

    @Override
    public String toString() {
        return "Odontologo= " +
                "id: " + id +
                ", nombre: " + nombre +
                ", apellido: " + apellido +
                ", matricula: " + matricula
                ;
    }
}
