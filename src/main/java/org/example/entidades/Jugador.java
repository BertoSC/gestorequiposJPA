package org.example.entidades;

import jakarta.persistence.*;

@Entity
public class Jugador {
    /*
    * idJugador: identificador del jugador.
   nombre: nombre del jugador.
   apellidos: apellidos del jugador.
    equipo: equipo al que pertenece el jugador.
    altura: altura del jugador (Double).
    peso: peso del jugador (Double).
    numero: número de camiseta del jugador (SmallInt).
    anoDraft: año de elección en el draft (entero).-
    numeroDraft: número de elección en el draft (SmallInt).
    rondaDraft: ronda de elección en el draft (SmallInt).
    posicion: posición en la que juega (base, escolta, alero, ala-pívot, pívot, como enumeración, que debe guardarse como ‘G’, ‘C’, ‘F’, ‘F-C’, ‘C-F’).
    pais: país de origen del jugador.
    colegio: universidad o equipo en el que jugó.
    foto: foto del jugador.*    *
    * */
    @Id
    private Long idjugador;
    private String nombre;
    private String apellidos;
    private Equipo equipo;
    private double altura;
    private double peso;
    private short numero;
    private int anoDraft;
    private short numeroDraft;
    private short rondaDraft;
    private Posicion posicion;
    private String pais;
    private String colegio;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte [] foto;


}
