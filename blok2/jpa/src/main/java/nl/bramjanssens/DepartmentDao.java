package nl.bramjanssens;

import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static nl.bramjanssens.util.EntityManagerProducer.MySQL;

@Dependent
@Slf4j
public class DepartmentDao {

    private final EntityManager em; // Application managed EntityManager

    public DepartmentDao() {
        this.em = MySQL.connection().createEntityManager();
    }

    public void create(Department e) {
        // Application managed transaction
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(e);  // INSERT INTO
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            log.error("Bah... :-( ", ex);
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

    public Department find(String depName) {
        return em.createQuery("select e from Department e where e.name = :depName", Department.class)
                .setParameter("depName", depName)
                .getSingleResult();
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

    // --- technische (on)zin:

    @PreDestroy
    public void close() {
        log.info("------------------------ PreDestroy" + this);
        em.close();
    }
}
