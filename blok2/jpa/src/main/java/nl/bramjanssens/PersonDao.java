package nl.bramjanssens;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Singleton
public class PersonDao {

    // INJECT?
    private final EntityManager em;

    public PersonDao() {
        this.em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    }

    public void insert(Person p) {
        // Application managed transaction
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);  // INSERT INTO
        transaction.commit();
    }

    public Person select(int id) {
        return em.find(Person.class, id);
    }

    public void close() {
        em.close();
    }
}
