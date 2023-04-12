package nl.belastingdienst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @Slf4j
public class Person {

    private Logger log = LoggerFactory.getLogger(Person.class);

    public void doeiets() {
        log.debug("ik doe iets...");
    }
}
