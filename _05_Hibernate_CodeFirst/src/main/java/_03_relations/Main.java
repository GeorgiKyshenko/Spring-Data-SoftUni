package _03_relations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        BasicLabel label = new BasicLabel("Blue");
        ProductionBatch batch = new ProductionBatch(LocalDate.now());
        BasicIngredient ingredient = new BasicIngredient(100,"Lavender");
        BasicIngredient ingredient2 = new BasicIngredient(10,"Vit C");
        BasicIngredient ingredient3 = new BasicIngredient(200,"Biotin");

        BasicShampoo shampoo = new BasicShampoo("shower", label, batch);

        shampoo.addIngredient(ingredient);
        shampoo.addIngredient(ingredient2);
        shampoo.addIngredient(ingredient3);


        entityManager.persist(ingredient);
        entityManager.persist(ingredient2);
        entityManager.persist(ingredient3);

        entityManager.persist(label);
        entityManager.persist(batch);
        entityManager.persist(shampoo);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
