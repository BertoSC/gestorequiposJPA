package org.example.entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EquipoDAO implements DAO<Equipo>{
    EntityManager em;

    public EquipoDAO (EntityManager em){
        this.em=em;
    }

    @Override
    public Equipo get(long id) {
        Equipo equipoAct = em.find(Equipo.class, id);
        return equipoAct;
    }

    @Override
    public List<Equipo> getAll() {
        TypedQuery<Equipo> consulta = em.createQuery("select e from Equipo e", Equipo.class);
        List <Equipo> equipos = consulta.getResultList();
        return equipos;
    }

    @Override
    public void save(Equipo equipo) {
        em.getTransaction().begin();
        em.persist(equipo);
        em.getTransaction().commit();

    }

    @Override
    public void update(Equipo equipo) {
        em.getTransaction().begin();
        em.merge(equipo);
        em.getTransaction().commit();

    }

    @Override
    public void delete(Equipo equipo) {
        em.getTransaction().begin();
        em.remove(equipo);
        em.getTransaction().commit();

    }

    @Override
    public void deleteById(long id) {
        Equipo eqAct = get(id);
        delete(eqAct);
    }

    @Override
    public List<Long> getAllIds() {
        TypedQuery<Long> consulta = em.createQuery("select e.idEquipo from Equipo e", Long.class);
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
