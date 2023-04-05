package nl.bramjanssens.inheritance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermanentEmployeeTest {

    @Test
    void calculateSalary() {
        // given
        PermanentEmployee p = new PermanentEmployee();
        p.setPosition(14);

        // when
        double actual = p.calculateSalary();

        // then
        assertEquals(1400d, actual);
    }

    @Test
    void compareTwoPEs() {
        PermanentEmployee p = new PermanentEmployee();
        p.setPosition(14);

        PermanentEmployee p2 = new PermanentEmployee();
        p2.setPosition(16);

        if (p.compareTo(p2) < 0) {
            System.out.println("kleiner");
        }
    }

    @Test
    void compareListOfPEs() {
        PermanentEmployee p = new PermanentEmployee();
        p.setPosition(16);

        PermanentEmployee p2 = new PermanentEmployee();
        p2.setPosition(14);

        List<PermanentEmployee> permanentEmployees = new ArrayList<>(List.of(p, p2));
        Collections.sort(permanentEmployees);
        
        permanentEmployees.forEach(System.out::println);
    }
}
