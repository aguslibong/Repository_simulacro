package org.example.EntityManagerProvider;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {
    private static EntityManagerProvider emp;
    private EntityManager em;

    private EntityManagerProvider() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        if (emp == null){
            emp = new EntityManagerProvider();
        }
        return emp.em;
    }

}
