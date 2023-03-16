package nl.bramjanssens.firsttry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeerTest {

    // test methodes maken:
    @Test
    void givenABeerCollectionWhenThereAreMoreBeersThenCorrectMessageIsReturned() {
        // given ....

        // when ....


        // then ....
        assertEquals("One bottle of beer", Beer.bottles(1));
        assertEquals("10 bottles of beer", Beer.bottles(10));
    }

    @Test
    void givenABeerCollectionWhenThereAreNoMoreBeersThenCorrectMessageIsReturned() {
        assertEquals("No more bottles of beer", Beer.bottles(0));
    }
}
