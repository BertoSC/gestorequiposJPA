package org.example.entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EntrenadorDAO implements DAO<Entrenador>{

    EntityManager em;

    public EntrenadorDAO(EntityManager em){
        this.em=em;
    }

    @Override
    public Entrenador get(long id) {
        Entrenador entr = em.find(Entrenador.class, id);
        return entr;
    }

    @Override
    public List<Entrenador> getAll() {
        TypedQuery<Entrenador> consulta = em.createQuery("select e from Entrenador e", Entrenador.class);
        List<Entrenador> listaEntr = consulta.getResultList();
        return listaEntr;
    }

    @Override
    public void save(Entrenador entrenador) {
        em.getTransaction().begin();
        em.persist(entrenador);
        em.getTransaction().commit();

    }

    @Override
    public void update(Entrenador entrenador) {
        em.getTransaction().begin();
        em.merge(entrenador);
        em.getTransaction().commit();

    }

    @Override
    public void delete(Entrenador entrenador) {
        em.getTransaction().begin();
        em.remove(entrenador);
        em.getTransaction().commit();

    }

    @Override
    public void deleteById(long id) {
        Entrenador entr = get(id);
        delete(entr);
    }

    @Override
    public List<Long> getAllIds() {
        TypedQuery<Long> consulta = em.createQuery("select e.idEntrenador from Entrenador e", Long.class);
        List <Long> ids = consulta.getResultList();
        return ids;
    }

    @Override
    public void deleteAll() {
        List <Long> ids = getAllIds();
        for (Long id: ids){
            deleteById(id);
        }

    }
}
