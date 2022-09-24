package Soft_Uni_Tasks;

import entities.Town;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class _03_ContainsEmployee {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String[] searchFor = scanner.nextLine().split(" ");

        Long employeeCount = entityManager.createQuery("select count (e) from Employee e " +
                        "where e.firstName = :first_name and e.lastName = :last_name", Long.class)
                .setParameter("first_name", searchFor[0])
                .setParameter("last_name", searchFor[1])
                .getSingleResult();

        if (employeeCount > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
