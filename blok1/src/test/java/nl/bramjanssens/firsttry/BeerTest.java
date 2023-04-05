package nl.bramjanssens.firsttry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeerTest {

    // test methodes maken:
    @Test
    void givenABeerCollectionWhenThereIsOneBeerThenCorrectMessageIsReturned() {
        // given ....
        String oneBottleOfBeer = "One bottle of beer";

        // when ....
        String actual = Beer.bottles(1);

        // then ....
        assertEquals(oneBottleOfBeer, actual);
    }

    @Test
    void givenABeerCollectionWhenThereAreMoreBeersThenCorrectMessageIsReturned() {
        // given ....
        String ten = "10 bottles of beer";

        // when ....
        String actual = Beer.bottles(10);

        // then ...
        assertEquals(ten, actual);
    }

    @Test
    void givenABeerCollectionWhenThereAreNoMoreBeersThenCorrectMessageIsReturned() {
        // given when then
        assertEquals("No more bottles of beer", Beer.bottles(0));
    }
}
