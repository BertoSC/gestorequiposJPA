package org.example.entidades;

import jakarta.persistence.*;

@Entity
public class Equipo {
    @Id
    Long idEquipo;
    String nombre;
    String ciudad;
    @Convert(converter = ConferenciaConverter.class)
    Conferencia conferencia;
    @Convert(converter = DivisionConverter.class)
    Division division;
    String nombreCompleto;
    @Column(unique = true)
    String abreviatura;
    @OneToOne (mappedBy = "equipo")
    Entrenador entrenador;

    public Equipo() {
    }

    public Equipo(String nombre, String ciudad, Conferencia conferencia, Division division, String nombreCompleto, String abreviatura) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
        this.nombreCompleto = nombreCompleto;
        this.abreviatura = abreviatura;
    }

    public Equipo(String nombre, Long idEquipo, String ciudad, Conferencia conferencia, Division division, String nombreCompleto, String abreviatura) {
        this.nombre = nombre;
        this.idEquipo = idEquipo;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
        this.nombreCompleto = nombreCompleto;
        this.abreviatura = abreviatura;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public Equipo setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Equipo setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Equipo setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public Equipo setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
        return this;
    }

    public Division getDivision() {
        return division;
    }

    public Equipo setDivision(Division division) {
        this.division = division;
        return this;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Equipo setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public Equipo setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
        return this;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo=" + idEquipo +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", conferencia=" + conferencia +
                ", division=" + division +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                '}';
    }
}
