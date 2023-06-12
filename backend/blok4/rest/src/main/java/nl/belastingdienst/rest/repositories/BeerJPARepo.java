package nl.belastingdienst.rest.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class BeerJPARepo {

    @PersistenceContext(name = "MySQL")
    private EntityManager em;
}
