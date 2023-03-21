package nl.bramjanssens;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimitiveWrappersTest {

    private PrimitiveWrappers target;

    @BeforeEach
    void setUp() {
        target = new PrimitiveWrappers();
    }

    @Test
    void testTelEenOp() {
        // given
        String anInput = "42";

        // when
        int actual = target.telEenOp(anInput);

        // then
        Assertions.assertEquals(43, actual);
    }
}
