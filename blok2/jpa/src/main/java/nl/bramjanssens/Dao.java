package nl.bramjanssens;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;

import static nl.bramjanssens.util.EntityManagerProducer.MySQL;

public abstract class Dao {

    // @PersistenceContext // when deployed in a JEE container
    protected final EntityManager em = MySQL.connection().createEntityManager();

    @PreDestroy
    public void close() {
        // log.info("------------------------ PreDestroying " + this);
        em.close();
    }

    public EntityManager getEm() {
        return em;
    }
}
