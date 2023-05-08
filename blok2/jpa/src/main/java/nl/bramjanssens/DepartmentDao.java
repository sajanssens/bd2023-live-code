package nl.bramjanssens;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Dependent
@Slf4j
public class DepartmentDao {

    // @PersistenceContext // when deployed in a JEE container
    private EntityManager em; // Application managed EntityManager

    @Inject
    public DepartmentDao(EntityManager em) {
        this.em = em;
    }

    // Application managed EntityManager
    public void create(Department e) {
        // Application managed transaction
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(e);  // INSERT INTO
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            // TODO
        }
    }

    // Als alternatief voor Department.employees op EAGER zetten
    public List<Person> getAllEmployees(String depName) {
        return em.createQuery("""
                        select emps 
                        from Department d
                        JOIN d.employees emps
                        where d.name = :depName""", Person.class)
                .setParameter("depName", depName)
                .getResultList();
    }

    public Department read(int id) {
        return em.find(Department.class, id);
    }

    public List<Department> findAll() {
        return em.createQuery("select e from Department e", Department.class).getResultList();
    }

    public void remove(long id) {
        Department select = em.find(Department.class, id);
        if (select != null) {
            em.getTransaction().begin();
            em.remove(select);
            em.getTransaction().commit();
        }
    }

    public Department update(Department e) {
        em.getTransaction().begin();
        Department merged = em.merge(e);
        em.getTransaction().commit();
        return merged;
    }

    // --- technische zin:

    public EntityManager getEm() { return em; }

    @PostConstruct
    void post() {
        log.info("------------------------ PostConstruct" + this);
    }

    @PreDestroy
    public void close() {
        log.info("------------------------ PreDestroy" + this);
        em.close();
    }
}
