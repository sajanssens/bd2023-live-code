package nl.bramjanssens.mutationtesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Test
    void isAllowedToBuyAlcohol_oldProfessor_isAllowed() {
        var customer = new Customer("Professor X", 96);
        assertTrue(customer.isAllowedToBuyAlcohol(customer));
    }

    @Test // kills ConditionalsBoundaryMutator
    void isAllowedToBuyAlcohol_18yo_isAllowed() {
        var customer = new Customer("Joepie", 18);
        assertTrue(customer.isAllowedToBuyAlcohol(customer));
    }

    @Test // kills BooleanTrueReturnValsMutator
    void isAllowedToBuyAlcohol_underAged_isNotAllowed() {
        var customer = new Customer("Poepie", 8);
        assertFalse(customer.isAllowedToBuyAlcohol(customer));
    }
}
