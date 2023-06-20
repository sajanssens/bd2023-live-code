package nl.belastingdienst.rest.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import nl.belastingdienst.rest.domain.Beer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @ApplicationScoped
@Slf4j
public class Dataloader {

    @PersistenceContext(name = "MySQL")
    private EntityManager em;

    private final List<Beer> beers = new ArrayList<>(Arrays.asList(
            new Beer("Leffe", "Blond", 1.89),
            new Beer("Leffe", "Tripel", 1.99),
            new Beer("Grolsch", "Pils", 0.89),
            new Beer("LaTrappe", "Dubbel", 2))
    );

    // CDI alternative for @Startup from EJB.
    // @Transactional
    // public void init(@Observes @Initialized(ApplicationScoped.class) Object pointless) {
    //     log.info("Filling some beers.........");
    //     for (Beer beer : this.beers) {
    //         em.persist(beer);
    //     }
    // }
}
