package org.example.repository;

import java.util.List;
import java.util.concurrent.TimeUnit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Repository;

public class RepositoryDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    private static EntityManager em = emf.createEntityManager();

    public static void saveAll(List<Repository> repositories) {
        int retries = 5;  // Número de reintentos
        while (retries > 0) {
            try {
                em.getTransaction().begin();
                for (Repository repository : repositories) {
                    em.merge(repository);
                }
                em.getTransaction().commit();
                break;  // Salir del bucle si tiene éxito
            } catch (Exception e) {
                em.getTransaction().rollback();
                retries--;
                if (retries == 0) {
                    throw new RuntimeException("Failed to save repositories after retries", e);
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(200);  // Esperar antes de reintentar
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            } finally {
                if (em != null && em.isOpen()) {
                    em.close();
                }
                em = emf.createEntityManager();  // Crear una nueva instancia de EntityManager para el siguiente intento
            }
        }
    }
}
