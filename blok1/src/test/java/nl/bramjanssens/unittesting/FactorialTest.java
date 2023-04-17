package nl.bramjanssens.unittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @Test
    void whenFaculty0ThenResultIs1() {
        Factorial sut = new Factorial();
        long result = sut.fac(0);
        assertEquals(1, result);
    }

    @Test
    void whenFaculty1ThenResultIs1() {
        Factorial sut = new Factorial();
        long result = sut.fac(1);
        assertEquals(1, result);
    }

    @Test
    void whenFaculty2ThenResultIs2() {
        Factorial sut = new Factorial();
        long result = sut.fac(2);
        assertEquals(2, result);
    }

    @Test
    void whenFacultyMinus1ThenResultIs1() {
        Factorial sut = new Factorial();
        assertThrows(IllegalArgumentException.class, () -> sut.fac(-1));
    }

    @Test
    void whenFacultyNThenResultIsNFaculty() {
        Factorial sut = new Factorial();
        long result = sut.fac(2);
        assertEquals(2, result);
    }
}
