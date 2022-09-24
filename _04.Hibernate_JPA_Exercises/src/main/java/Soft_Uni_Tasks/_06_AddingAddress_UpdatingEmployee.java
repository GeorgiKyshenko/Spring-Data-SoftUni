package Soft_Uni_Tasks;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _06_AddingAddress_UpdatingEmployee {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        String addressText = "Vitoshka 15";
        Address address = new Address();
        address.setText(addressText);
        entityManager.persist(address);

        String lastName = scanner.nextLine();

/*
 Employee employee = entityManager.createQuery("select e from Employee e where e.lastName = :name", Employee.class) // Employee.class - return type !
         .setParameter("name", lastName)
         .getSingleResult();

       employee.setAddress(address);
       entityManager.persist(employee);
*/


        entityManager.createQuery("update Employee e set e.address = :address " +
                        "where e.lastName = :name")
                .setParameter("address", address)
                .setParameter("name", lastName)
                .executeUpdate();


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
