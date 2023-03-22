package nl.bramjanssens.arraylists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CijferadministratieMetListTest {

    private CijferadministratieMetList target;

    @BeforeEach
    void setUp() {
        this.target = new CijferadministratieMetList();
        this.target.voegNieuweCijfersToe(/*1, 2, 3,*/ 7, 8, 9);
    }

    @Test
    void berekenGemiddeldeImperativeProceduralStyle() {
        double avg = this.target.berekenGemiddeldeImperativeProceduralStyle();
        assertEquals(8.0d, avg);
    }

    @Test
    void berekenGemiddeldeDeclarativeFunctionalStyle() {
        double avg = this.target.berekenGemiddeldeDeclarativeFunctionalStyle();
        assertEquals(8.0d, avg);
    }
}
