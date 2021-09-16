package com.dh.clinica.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName= "paciente_sequence")
    @GeneratedValue (strategy= GenerationType.SEQUENCE, generator = "sequence_generator")
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String dni;
    @Column
    private Date fechaIngreso;

    @OneToOne (mappedBy = "domicilio", cascade = CascadeType.REMOVE)
    @Column
    private Domicilio domicilio;

    public Paciente() {
    }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }

    public void setDni(String dni) { this.dni = dni; }

    public Date getFechaIngreso() { return fechaIngreso; }

    public void setFechaIngreso(Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public Domicilio getDomicilio() { return domicilio; }

    public void setDomicilio(Domicilio domicilio) { this.domicilio = domicilio; }

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
