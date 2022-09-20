import Entities.Student;
import Entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student("Ivan", 27);
        entityManager.persist(student);

        Student student2 = new Student("Petar", 34);
        entityManager.persist(student2);

        Teacher teacher = new Teacher("Petya", LocalDate.now());
        entityManager.persist(teacher);


        /*
        Student first = entityManager.find(Student.class,1);
        entityManager.remove(first);

        изтриване по id
*/

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
