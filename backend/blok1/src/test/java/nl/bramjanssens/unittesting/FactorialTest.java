package nl.bramjanssens.unittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @Test
    void whenFactorial0ThenResultIs1() {
        Factorial sut = new Factorial();
        long result = sut.fac(0);
        assertEquals(1, result);
    }

    @Test
    void whenFactorial1ThenResultIs1() {
        Factorial sut = new Factorial();
        long result = sut.fac(1);
        assertEquals(1, result);
    }

    @Test
    void whenFactorial2ThenResultIs2() {
        Factorial sut = new Factorial();
        long result = sut.fac(2);
        assertEquals(2, result);
    }

    @Test
    void whenFactorialMinus1ThenResultIs1() {
        Factorial sut = new Factorial();
        assertThrows(IllegalArgumentException.class, () -> sut.fac(-1));
    }

    @Test
    void whenFactorialWithSmallNThenResultIsNFactorial() {
        Factorial sut = new Factorial();
        long result = sut.fac(10);
        assertEquals(3_628_800, result);
    }
}
