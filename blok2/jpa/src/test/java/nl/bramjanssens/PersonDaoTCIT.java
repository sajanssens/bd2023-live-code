package nl.bramjanssens;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
class PersonDaoTCIT {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:15")
                    .withDatabaseName("person")
                    .withUsername("postgres")
                    .withPassword("postgres");

    private Person person;
    private EntityManager entityManagerForTest;

    @BeforeEach
    public void init() {
        System.setProperty("db.port", postgreSQLContainer.getFirstMappedPort().toString());
        System.setProperty("db.host", postgreSQLContainer.getHost());
        var emf = Persistence.createEntityManagerFactory("test-containers");
        var em = emf.createEntityManager();
        entityManagerForTest = emf.createEntityManager();
        sut = new PersonDao(em);
        person = Person.builder().name("Henk").age(12).build();
    }

    private PersonDao sut;

    @Test
    void whenInsertWithValidPersonThenTransactionIsCommitted() {
        // given
        Person bram = Person.builder().name("Bram").build();

        // when
        sut.create(bram);

        // then
        Person select = sut.read(1);
        assertNotNull(select);
    }

    @Test
    void whenPersonIsPutIntoTeamThenTheyArePersisted() {
        Team psv = Team.builder().name("PSV").build();
        Person asjer = Person.builder().name("Asjer").mijnVoetbalteam(psv).build();

        sut.create(asjer);
    }
}
