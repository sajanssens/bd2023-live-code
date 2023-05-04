package nl.bramjanssens;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

@Dependent
@Slf4j
public class PersonDao {

    // @PersistenceContext // when deployed in a JEE container
    private EntityManager em; // Application managed EntityManager

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

    public EntityManager getEm() { return em; }

    @PostConstruct
    void post() {
        log.info("------------------------ PostConstruct" + this);
    }

    @PreDestroy
    public void close() {
        log.info("------------------------ PreDestroy" + this);
        em.close();
    }
}
