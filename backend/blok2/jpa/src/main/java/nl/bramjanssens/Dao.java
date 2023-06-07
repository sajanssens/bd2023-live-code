package nl.bramjanssens;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import nl.bramjanssens.util.MySql;

public abstract class Dao {

    protected final EntityManager em = MySql.connection().createEntityManager();

    @PreDestroy
    public void close() {
        // log.info("------------------------ PreDestroying " + this);
        em.close();
    }

    public EntityManager getEm() {
        return em;
    }
}
