package nl.belastingdienst.rest.repositories;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import nl.belastingdienst.rest.domain.Beer;
import nl.belastingdienst.rest.domain.BeerInput;
import nl.belastingdienst.rest.util.BEER;

@BEER @Dependent // scope/lifetime/lifecycle is afhank. van de aanroeper
public class BeerRepo extends Repo<Beer> {

    @PersistenceContext
    private EntityManager em;

    @Transactional // Needed when CDI bean, not needed when EJB
    public Beer edit(int id, BeerInput input) {
        Beer beer = get(id).merge(input);
        System.out.println(beer);
        return em.merge(beer);
    }

    @Transactional
    // @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void remove(int id) { em.remove(get(id)); }

    @Override public Class<Beer> E() { return Beer.class; }
}
