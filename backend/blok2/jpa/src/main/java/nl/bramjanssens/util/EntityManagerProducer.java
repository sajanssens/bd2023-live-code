package nl.bramjanssens.util;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

@Singleton // CDI: neem deze class als hij als alternatief is geactiveerd in beans.xml
public class EntityManagerProducer {

    @Produces
    public EntityManager em() {
        return Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    }
}
