package nl.belastingdienst.rest.repositories;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nl.belastingdienst.rest.domain.Beer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton @Startup
// @TransactionManagement
public class Dataloader {

    @PersistenceContext/*(name = "MySQL")*/
    private EntityManager em;

    private final List<Beer> beers = new ArrayList<>(Arrays.asList(
            new Beer("Leffe", "Blond", 1.89),
            new Beer("Leffe", "Tripel", 1.99),
            new Beer("Grolsch", "Pils", 0.89),
            new Beer("LaTrappe", "Dubbel", 2))
    );

    public Dataloader() {
        //....
    }

    @PostConstruct // lifecycle hook
    // @Transactional
    public void init() {
        System.out.println("Filling some beers.........");
        for (Beer beer : this.beers) {
            em.persist(beer);
        }
    }
}
