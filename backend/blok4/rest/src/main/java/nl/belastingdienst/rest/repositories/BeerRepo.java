package nl.belastingdienst.rest.repositories;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nl.belastingdienst.rest.domain.Beer;
import nl.belastingdienst.rest.domain.BeerInput;

import java.util.List;

@Dependent // scope/lifetime/lifecycle is afhank. van de aanroeper
public class BeerRepo extends Repo<Beer> {

    @PersistenceContext
    private EntityManager em;

    // @Transactional
    public Beer add(Beer b) { em.persist(b); return b; }

    // @Transactional
    public Beer edit(int id, BeerInput input) {
        Beer beer = get(id).merge(input);
        System.out.println(beer);
        return em.merge(beer);
    }

    // @Transactional
    // @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void remove(int id) { em.remove(get(id)); }
}
