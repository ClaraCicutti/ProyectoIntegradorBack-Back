package com.dh.clinica.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "odontologos")
public class Odontologo {

    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Integer matricula;

//    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.REMOVE)
//    private Set<Paciente> pacientes = new HashSet<>();

    //    //    Prueba con lo que estaba en playground
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Paciente paciente;

    public Odontologo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

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
