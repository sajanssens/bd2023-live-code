package nl.bramjanssens.inheritance;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    @Test
    void callOverriddenMethod() {
        // polymorfisme
        Employee employee;
        PermanentEmployee p = new PermanentEmployee();
        p.setPosition(14);
        employee = p;

        double actual = employee.calculateSalary();
        assertEquals(1400d, actual);
    }

    @Test
    void callStaticOverriddenMethod() {
        // polymorfisme
        Employee employee;
        PermanentEmployee p = new PermanentEmployee();
        p.setPosition(14);
        employee = p;

        double actual = employee.geefHetUniverseleAntwoord();
        assertEquals(42, actual);

        double actualToo = p.geefHetUniverseleAntwoord();
        assertEquals(43, actualToo);
    }

    @Test
    void callCalculateSalaryOnManyEmployees() {
        List<Employee> emps = List.of(new PermanentEmployee(), new PermanentEmployee(), new TemporaryEmployee());

        for (Employee emp : emps) {
            emp.calculateSalary();
        }
    }
}
