package nl.bramjanssens;

import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

@EnableAutoWeld
@AddBeanClasses({EntityManagerProducerAlt.class, PersonDao.class}) // beans.xml
@EnableAlternatives(EntityManagerProducerAlt.class)
class PersonDaoIT {

    @Inject
    private PersonDao target;

    @Test
    void whenInsertWithValidPersonThenTransactionIsCommitted() {
        // when
        target.insert(new Person());

        // then

    }
}
