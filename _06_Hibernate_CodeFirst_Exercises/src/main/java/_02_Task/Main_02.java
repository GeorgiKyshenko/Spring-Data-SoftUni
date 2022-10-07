package _02_Task;

import _02_Task.entities.Customer;
import _02_Task.entities.Product;
import _02_Task.entities.Sale;
import _02_Task.entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main_02 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CodeFirstEx");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = new Product("product1", 10, BigDecimal.TEN);
        Customer customer = new Customer("customer1", "customer@gmail", "12345");
        StoreLocation location = new StoreLocation("location1");
        Sale sale = new Sale(product, customer, location);


        entityManager.persist(product);
        entityManager.persist(customer);
        entityManager.persist(location);
        entityManager.persist(sale);


        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
