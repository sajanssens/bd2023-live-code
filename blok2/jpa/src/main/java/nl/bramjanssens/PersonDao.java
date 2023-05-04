package nl.bramjanssens;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.sql.SQLException;

@Dependent
public class PersonDao {

    // @PersistenceContext when deployed in a JEE container
    private EntityManager em;

    @Inject
    public PersonDao(EntityManager em) {
        this.em = em;
    }

    // Application managed EntityManager
    public void insert(Person p) {
        // Application managed transaction
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(p);  // INSERT INTO
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            // TODO
        }
    }

    public Person select(int id) {
        return em.find(Person.class, id);
    }

    public void close() {
        em.close();
    }
}
