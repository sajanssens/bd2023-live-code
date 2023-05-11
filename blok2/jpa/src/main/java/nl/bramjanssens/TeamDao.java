package nl.bramjanssens;

import jakarta.enterprise.context.Dependent;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Dependent
@Slf4j
public class TeamDao extends Dao {

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
