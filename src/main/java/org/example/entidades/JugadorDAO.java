package org.example.entidades;

import jakarta.persistence.EntityManager;

import java.util.List;

public class JugadorDAO implements DAO<Jugador>{
    EntityManager em;

    public JugadorDAO(EntityManager em){
        this.em= em;
    }
    @Override
    public Jugador get(long id) {
        return null;
    }

    @Override
    public List<Jugador> getAll() {
        return List.of();
    }

    @Override
    public void save(Jugador jugador) {
        em.getTransaction().begin();
        em.persist(jugador);
        em.getTransaction().commit();

    }

    @Override
    public void update(Jugador jugador) {

    }

    @Override
    public void delete(Jugador jugador) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Long> getAllIds() {
        return List.of();
    }

    @Override
    public void deleteAll() {

    }
}
