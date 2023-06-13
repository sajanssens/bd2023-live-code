package nl.belastingdienst.rest.repositories;

import jakarta.inject.Singleton;
import jakarta.ws.rs.BadRequestException;
import nl.belastingdienst.rest.domain.Beer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton // stateful
public class BeerFakeRepo {

    private List<Beer> em = new ArrayList<>(Arrays.asList(new Beer(1, "Leffe", "Blond", 1.89), new Beer(2, "Leffe", "Tripel", 1.99), new Beer(3, "Grolsch", "Pils", 0.89), new Beer(4, "LaTrappe", "Dubbel", 2)));

    public Beer get(int id) {
        return this.em.stream().filter(b -> b.getId() == id).findFirst().orElseThrow(BadRequestException::new);
    }

    public List<Beer> getEm() {
        return em;
    }
}
