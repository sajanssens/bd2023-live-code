package nl.bramjanssens;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Dependent
@Slf4j
public class PersonDao extends Dao {

    // Application managed EntityManager
    public void create(Person p) {
        // Application managed transaction
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(p);  // INSERT INTO
            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            transaction.rollback();
        }
    }

    public Person read(int id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAll() {
        // JPQL: Java Persistence Query Language
        // TypedQuery<Person> q = em.createQuery("select p from Person p", Person.class);
        // List<Person> resultList = q.getResultList();
        // return resultList;
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }

    public List<Person> findAllNamed() {
        TypedQuery<Person> findAll = em.createNamedQuery("Person.findAll", Person.class);
        return findAll.getResultList();
    }

    public List<Person> findByName(String name) {
        TypedQuery<Person> query = em.createQuery("select p from Person p where p.name = :eenNaam", Person.class);
        query.setParameter("eenNaam", name);
        return query.getResultList();
    }

    public void remove(long id) {
        Person select = em.find(Person.class, id);
        if (select != null) {
            em.getTransaction().begin();
            em.remove(select);
            em.getTransaction().commit();
        }
    }

    public Person update(Person p) {
        em.getTransaction().begin();
        Person merged = em.merge(p);
        em.getTransaction().commit();
        return merged;
    }
}
