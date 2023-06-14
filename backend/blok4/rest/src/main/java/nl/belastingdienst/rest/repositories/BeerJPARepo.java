package nl.belastingdienst.rest.repositories;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import nl.belastingdienst.rest.domain.Beer;

import java.util.List;

@Dependent // scope/lifetime/lifecycle is afhank. van de aanroeper
public class BeerJPARepo {

    @PersistenceContext/*(name = "MySQL")*/
    private EntityManager em;

    public BeerJPARepo() {
        //....
    }

    @PostConstruct // lifecycle hook
    public void init() {
        // body van de ctor als je met CDI werkt
    }

    public List<Beer> getAll() {
        return em.createNamedQuery("Beer.findAll", Beer.class).getResultList();
    }

    public List<Beer> findByMake(String make) {
        return em.createQuery("select p from Beer p where p.make = :eenMake", Beer.class)
                .setParameter("eenMake", make)
                .getResultList();
    }



    @Transactional
    public Beer add(Beer b) { em.persist(b); return b; }

    @Transactional
    public Beer edit(Beer b) { return em.merge(b); }
}
