package Soft_Uni_Tasks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class _04_EmployeesSalaryOver50000 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        List<String> resultList = entityManager.createQuery("select e.firstName from Employee e " +
                "where e.salary > 50000", String.class).getResultList();

        String result = String.join("\n", resultList);
        System.out.println(result);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
