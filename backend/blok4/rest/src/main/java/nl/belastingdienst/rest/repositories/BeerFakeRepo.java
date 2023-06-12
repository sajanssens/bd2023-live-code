package nl.belastingdienst.rest.repositories;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.BadRequestException;
import nl.belastingdienst.rest.domain.Beer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Dependent
public class BeerFakeRepo {

    private List<Beer> emFake = new ArrayList<>(Arrays.asList(new Beer("Leffe", "Blond", 1.89), new Beer("Leffe", "Tripel", 1.99), new Beer("Grolsch", "Pils", 0.89), new Beer("LaTrappe", "Dubbel", 2)));

    public Beer get(int id) {
        return this.emFake.stream().filter(b -> b.getId() == id).findFirst().orElseThrow(BadRequestException::new);
    }

    public List<Beer> getEmFake() {
        return emFake;
    }
}
