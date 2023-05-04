package nl.bramjanssens;

import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableAutoWeld // make this test CDI-enabled
@AddBeanClasses({EntityManagerProducerAlt.class, PersonDao.class}) // beans.xml
@EnableAlternatives(EntityManagerProducerAlt.class)
class PersonDaoIT {

    @AfterEach
    public void teardown() {
        // If some tests have open transactions because of exceptions (like in testSaveDetachedEntityWithoutCatchAndRollback)
        if (target.getEm().getTransaction().isActive()) {
            target.getEm().getTransaction().rollback();
        }
    }

    @Inject
    private PersonDao target;

    @BeforeEach
    void setUp() {
        // target.
    }

    @Test
    void whenInsertValidPersonThenItIsInsertedInTheDatabase() {
        // given
        Person bram = Person.builder().name("Bram").build();

        // when
        target.insert(bram);

        // then
        Person select = target.select(1);
        assertNotNull(select);
    }

    @Test
    void whenInsertValidPersonsTheyAreInsertedInTheDatabase() {
        // given
        int initialSize = target.findAll().size();
        Person bram = Person.builder().name("Bram1").build();
        Person bram2 = Person.builder().name("Bram2").build();
        Person bram3 = Person.builder().name("Bram3").build();

        // when
        target.insert(bram);
        target.insert(bram2);
        target.insert(bram3);

        // then
        int finalSize = target.findAll().size();

        assertTrue(finalSize == initialSize + 3);
    }
}
