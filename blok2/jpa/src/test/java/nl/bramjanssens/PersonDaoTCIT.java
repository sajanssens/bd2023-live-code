package nl.bramjanssens;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

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

  private PersonDao sut;

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

  @Test
  void whenInsertWithValidPersonThenTransactionIsCommitted() {
    // when
    sut.insert(person);
    Person actual = sut.select(1);
    Assertions.assertNotNull(actual);
    // then

  }
}
