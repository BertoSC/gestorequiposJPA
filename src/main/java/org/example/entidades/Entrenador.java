package org.example.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idEntrenador;
    String nombre;
    LocalDate fechaNacimiento;
    int salario;
    @OneToOne
    @JoinColumn(name = "id_equipo")
    Equipo equipo;

    public Entrenador() {
    }

    public Entrenador(String nombre, LocalDate fechaNacimiento, int salario, Equipo equipo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.equipo = equipo;
    }

    public Entrenador(LocalDate fechaNacimiento, int salario, String nombre) {
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.nombre = nombre;
    }

    public Entrenador(Long idEntrenador, String nombre, LocalDate fechaNacimiento, int salario, Equipo equipo) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.equipo = equipo;
    }

    public Long getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "idEntrenador=" + idEntrenador +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", salario=" + salario +
                ", equipo=" + equipo +
                '}';
    }
}
