package nl.bramjanssens;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPADemo {

    public static void main(String[] args) {
        EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
        EntityManager em = mySQL.createEntityManager();

        // Application managed transaction
        EntityTransaction transaction = em.getTransaction();

        Person cornéSatriani = Person.builder().name("Corné Satriani").age(32).build();
        transaction.begin();
        em.persist(cornéSatriani);
        transaction.commit();

        mySQL.close();
    }
}
