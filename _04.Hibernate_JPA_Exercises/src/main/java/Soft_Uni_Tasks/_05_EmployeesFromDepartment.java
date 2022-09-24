package Soft_Uni_Tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class _05_EmployeesFromDepartment {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        String department = "Research and Development";

        entityManager.createQuery("select e from Employee e where e.department.name = :departmentName " +
                        "order by  e.salary asc, e.id asc", Employee.class)
                .setParameter("departmentName", department)
                .getResultStream()
                .forEach(e -> {
                    String format = String.format("%s %s from %s - $%.2f",
                            e.getFirstName(), e.getLastName(), department, e.getSalary());

                    System.out.println(format);
                });


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
