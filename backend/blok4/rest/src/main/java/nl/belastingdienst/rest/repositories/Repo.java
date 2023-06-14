package nl.belastingdienst.rest.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import nl.belastingdienst.rest.domain.AbstractEntity;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public abstract class Repo<E extends AbstractEntity<Integer>> {

    @PersistenceContext // Container managed persistence context
    protected EntityManager em;

    public Collection<E> getAll() {
        return em.createNamedQuery(typeSimple() + ".findAll", E()).getResultList();
    }

    public E get(Integer id) { return em.find(E(), id); }

    public Collection<E> getByQ(String q) {
        TypedQuery<E> namedQuery = em.createNamedQuery(typeSimple() + ".search", E());
        namedQuery.setParameter("q", "%" + q + "%");
        return namedQuery.getResultList();
    }

    @Transactional
    public E add(E c) {
        em.persist(c);
        return c;
    }

    public boolean remove(String id) {
        E e = em.find(E(), id);
        if (e == null) return false;

        em.remove(e);
        return true;
    }

    public E update(Integer id, E e) {
        E found = em.find(E(), id);
        if (found == null) throw new BadRequestException("Entity with id " + id + " not found.");

        e.setId(id);
        return em.merge(e);
    }

    private String typeSimple() { return E().getSimpleName(); }

    @SuppressWarnings("unchecked")
    private Class<E> E() {
        ParameterizedType thisDaoClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<E>) thisDaoClass.getActualTypeArguments()[0];
    }
}

