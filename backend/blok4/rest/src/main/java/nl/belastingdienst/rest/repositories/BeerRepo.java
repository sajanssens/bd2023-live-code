package nl.belastingdienst.rest.repositories;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.BadRequestException;
import nl.belastingdienst.rest.domain.Beer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
public class BeerRepo {

    List<Beer> beers = new ArrayList<>(Arrays.asList(
            new Beer("Leffe", "Blond", 1.89),
            new Beer("Leffe", "Tripel", 1.99),
            new Beer("Grolsch", "Pils", 0.89),
            new Beer("LaTrappe", "Dubbel", 2)
    ));

    public Beer get(int id) {
        return this.beers.stream().filter(b -> b.getId() == id).findFirst().orElseThrow(BadRequestException::new);
    }

    public List<Beer> getBeers() {
        return beers;
    }
}
