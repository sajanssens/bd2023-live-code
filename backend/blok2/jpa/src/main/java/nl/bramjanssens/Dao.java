package nl.bramjanssens;

import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public abstract class Dao {

    @Inject
    protected EntityManager em;

    @PreDestroy
    public void close() {
        // log.info("------------------------ PreDestroying " + this);
        em.close();
    }

    public EntityManager getEm() {
        return em;
    }
}
