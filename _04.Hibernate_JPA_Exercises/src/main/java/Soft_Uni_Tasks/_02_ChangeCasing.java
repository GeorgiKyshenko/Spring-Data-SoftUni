package Soft_Uni_Tasks;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class _02_ChangeCasing {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Query from_town = entityManager.createQuery("SELECT t FROM Town t", Town.class);
        List<Town> townList = from_town.getResultList();

        for (Town town : townList) {
            String name = town.getName();
            if (name.length() <= 5) {
                name = name.toUpperCase();
                town.setName(name);

                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
