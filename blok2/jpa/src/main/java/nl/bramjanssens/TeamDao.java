package nl.bramjanssens;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static nl.bramjanssens.util.EntityManagerProducer.MySQL;

@Dependent
@Slf4j
public class TeamDao {

    private final EntityManager em; // Application managed EntityManager

    public TeamDao() {
        this.em = MySQL.connection().createEntityManager();
    }

    public List<Person> findTeamMembersOf(String teamName) {
        return em.createQuery(
                        "select p from Person p " +
                                "join fetch p.mijnTeam t " +
                                "where t.name = :teamnaam",
                        Person.class)
                .setParameter("teamnaam", teamName)
                .getResultList();
    }
}
