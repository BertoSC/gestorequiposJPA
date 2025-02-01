package org.example.entidades;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class Jugador {
    @Id
    private Long idjugador;
    private String nombre;
    private String apellidos;
    @ManyToOne
    @JoinColumn(name = "idEquipo")
    private Equipo equipo;
    private double altura;
    private double peso;
    private short numero;
    private int anoDraft;
    private short numeroDraft;
    private short rondaDraft;
    @ManyToMany
    @JoinTable(name = "JugadorPosicion",
    joinColumns = @JoinColumn(name = "idJugador"))
    List<PosicionEnt> posiciones;
    @Convert(converter = PosicionConverter.class)
    private Posicion posicion;
    private String pais;
    private String colegio;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte [] foto;

    public Jugador() {
    }

    public Jugador(Long idjugador, String nombre, String apellidos, Equipo equipo, double altura, double peso, short numero, int anoDraft, short numeroDraft, short rondaDraft, Posicion posicion, String pais, String colegio, byte[] foto) {
        this.idjugador = idjugador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.equipo = equipo;
        this.altura = altura;
        this.peso = peso;
        this.numero = numero;
        this.anoDraft = anoDraft;
        this.numeroDraft = numeroDraft;
        this.rondaDraft = rondaDraft;
        this.posicion = posicion;
        this.pais = pais;
        this.colegio = colegio;
        this.foto = foto;
    }

    public Jugador(Long idjugador, String nombre, String apellidos, Equipo equipo, double altura, double peso, short numero, int anoDraft, short numeroDraft, short rondaDraft, Posicion posicion, String pais, String colegio) {
        this.idjugador = idjugador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.equipo = equipo;
        this.altura = altura;
        this.peso = peso;
        this.numero = numero;
        this.anoDraft = anoDraft;
        this.numeroDraft = numeroDraft;
        this.rondaDraft = rondaDraft;
        this.posicion = posicion;
        this.pais = pais;
        this.colegio = colegio;
    }

    public Jugador(String nombre, String apellidos, Equipo equipo, double altura, double peso, short numero, int anoDraft, short numeroDraft, short rondaDraft, Posicion posicion, String pais, String colegio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.equipo = equipo;
        this.altura = altura;
        this.peso = peso;
        this.numero = numero;
        this.anoDraft = anoDraft;
        this.numeroDraft = numeroDraft;
        this.rondaDraft = rondaDraft;
        this.posicion = posicion;
        this.pais = pais;
        this.colegio = colegio;
    }

    public Long getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(Long idjugador) {
        this.idjugador = idjugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public int getAnoDraft() {
        return anoDraft;
    }

    public void setAnoDraft(int anoDraft) {
        this.anoDraft = anoDraft;
    }

    public short getNumeroDraft() {
        return numeroDraft;
    }

    public void setNumeroDraft(short numeroDraft) {
        this.numeroDraft = numeroDraft;
    }

    public short getRondaDraft() {
        return rondaDraft;
    }

    public void setRondaDraft(short rondaDraft) {
        this.rondaDraft = rondaDraft;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Double.compare(altura, jugador.altura) == 0 && Double.compare(peso, jugador.peso) == 0 && numero == jugador.numero && anoDraft == jugador.anoDraft && numeroDraft == jugador.numeroDraft && rondaDraft == jugador.rondaDraft && Objects.equals(idjugador, jugador.idjugador) && Objects.equals(nombre, jugador.nombre) && Objects.equals(apellidos, jugador.apellidos) && Objects.equals(equipo, jugador.equipo) && posicion == jugador.posicion && Objects.equals(pais, jugador.pais) && Objects.equals(colegio, jugador.colegio) && Arrays.equals(foto, jugador.foto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idjugador, nombre, apellidos, equipo, altura, peso, numero, anoDraft, numeroDraft, rondaDraft, posicion, pais, colegio);
        result = 31 * result + Arrays.hashCode(foto);
        return result;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idjugador=" + idjugador +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", equipo=" + equipo +
                ", altura=" + altura +
                ", peso=" + peso +
                ", numero=" + numero +
                ", anoDraft=" + anoDraft +
                ", numeroDraft=" + numeroDraft +
                ", rondaDraft=" + rondaDraft +
                ", posicion=" + posicion +
                ", pais='" + pais + '\'' +
                ", colegio='" + colegio + '\'' +
                '}';
    }
}
