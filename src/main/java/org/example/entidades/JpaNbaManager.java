package org.example.entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaNbaManager {
    public static final String NBA_H2 = "gestorequiposH2";

    public static final Map<String, EntityManagerFactory> instancies = new HashMap<>();

    private JpaNbaManager(){}

    private static boolean isEntityMangerFactoryClosed(String unidadPersistencia){
        return !instancies.containsKey(unidadPersistencia) || instancies.get(unidadPersistencia)==null||
                !instancies.get(unidadPersistencia).isOpen();
    }

    public static EntityManagerFactory getEntityManagerFactory(String unidadPersistencia){
        if (isEntityMangerFactoryClosed(unidadPersistencia)){
            synchronized (JpaNbaManager.class){
                if (isEntityMangerFactoryClosed(unidadPersistencia)){
                    instancies.put(unidadPersistencia, Persistence.createEntityManagerFactory(unidadPersistencia));
                }
            }
        }
        return instancies.get(unidadPersistencia);
    }

    public static EntityManager getEntityManager (String persistenceUnitName){
        return getEntityManagerFactory(persistenceUnitName).createEntityManager();
    }

    public static void close (String persistenceUnitName) {
        if (instancies.containsKey(persistenceUnitName)){
            instancies.get(persistenceUnitName).close();
            instancies.remove(persistenceUnitName);
        }

    }
}
