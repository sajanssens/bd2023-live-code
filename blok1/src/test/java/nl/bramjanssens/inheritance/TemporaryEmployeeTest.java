package nl.bramjanssens.inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemporaryEmployeeTest {

    @Test
    void calculateSalary() {
        TemporaryEmployee t = new TemporaryEmployee();
        t.setHours(40);

        double actual = t.calculateSalary();

        assertEquals(600, actual);
    }
}
