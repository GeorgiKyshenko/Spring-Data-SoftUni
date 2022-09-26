package _01_joined_pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Bike bike = new Bike(21);
        Car car = new Car(5);
        Truck truck = new Truck(50000);

        entityManager.persist(bike);
        entityManager.persist(car);
        entityManager.persist(truck);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
