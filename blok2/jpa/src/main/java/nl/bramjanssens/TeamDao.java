package nl.bramjanssens;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Dependent
@Slf4j
public class TeamDao {

    // @PersistenceContext // when deployed in a JEE container
    private EntityManager em; // Application managed EntityManager

    @Inject
    public TeamDao(EntityManager em) {
        this.em = em;
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
