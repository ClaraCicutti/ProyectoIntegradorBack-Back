package com.dh.clinica.model;

import javax.persistence.*;

@Entity
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName= "domicilio_sequence")
    @GeneratedValue (strategy= GenerationType.SEQUENCE, generator = "sequence_generator")
    private Integer id;
    @Column
    private String calle;
    @Column
    private String numero;
    @Column
    private String localidad;
    @Column
    private String provincia;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn ( name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    public Domicilio() {
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCalle() { return calle; }

    public void setCalle(String calle) { this.calle = calle; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public String getLocalidad() { return localidad; }

    public void setLocalidad(String localidad) { this.localidad = localidad; }

    public String getProvincia() { return provincia; }

    public void setProvincia(String provincia) { this.provincia = provincia; }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
