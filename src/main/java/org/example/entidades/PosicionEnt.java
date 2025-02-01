package org.example.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class PosicionEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPosicion;
    @Column(length = 50)
    String nombre;
    @Column(length = 3)
    String abreviatura;
    @Column(length = 255)
    String descripcion;

    public PosicionEnt() {
    }

    public PosicionEnt(String nombre, String abreviatura, String descripcion) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
    }

    public PosicionEnt(Long idPosicion, String nombre, String abreviatura, String descripcion) {
        this.idPosicion = idPosicion;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
    }

    public Long getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(Long idPosicion) {
        this.idPosicion = idPosicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosicionEnt that = (PosicionEnt) o;
        return Objects.equals(idPosicion, that.idPosicion) && Objects.equals(nombre, that.nombre) && Objects.equals(abreviatura, that.abreviatura) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPosicion, nombre, abreviatura, descripcion);
    }

    @Override
    public String toString() {
        return "PosicionEnt{" +
                "idPosicion=" + idPosicion +
                ", nombre='" + nombre + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
