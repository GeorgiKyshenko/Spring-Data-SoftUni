package _02_singele_table_pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Bike2 bike2 = new Bike2(21);
        Car2 car2 = new Car2(5);
        Truck2 truck2 = new Truck2(50000);

        entityManager.persist(bike2);
        entityManager.persist(car2);
        entityManager.persist(truck2);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
