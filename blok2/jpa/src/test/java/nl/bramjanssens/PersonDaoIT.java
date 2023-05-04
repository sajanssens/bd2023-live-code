package nl.bramjanssens;

import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
