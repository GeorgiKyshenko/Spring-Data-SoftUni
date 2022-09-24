package Soft_Uni_Tasks;


import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class _07_ListAddresses {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("select a from Address a order by a.employees.size desc", Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
