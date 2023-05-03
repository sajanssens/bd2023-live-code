package nl.bramjanssens;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JPADemo {

    public static void main(String[] args) {
        EntityManagerFactory mySQL = Persistence.createEntityManagerFactory("MySQL");
        EntityManager em = mySQL.createEntityManager();

        // Application managed transaction
        EntityTransaction transaction = em.getTransaction();

        Person cornéSatriani = Person.builder().name("Corné Satriani").age(32).build();
        transaction.begin();
        em.persist(cornéSatriani);  // INSERT INTO
        transaction.commit();

        Person person = em.find(Person.class, 1);
        log.info(person.toString());

        mySQL.close();
    }
}
