package nl.belastingdienst.rest.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import nl.belastingdienst.rest.domain.Beer;
import nl.belastingdienst.rest.domain.BeerInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("beers")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class BeersResource {

    List<Beer> beers = new ArrayList<>(Arrays.asList(
            new Beer("Leffe", "Blond", 1.89),
            new Beer("Leffe", "Tripel", 1.89),
            new Beer("Grolsch", "Pils", 0.89),
            new Beer("LaTrappe", "Dubbel", 2)
    ));

    @GET  // ../beers?q=leffe
    public List<Beer> search(@QueryParam("q") String q) {
        return q != null ?
                this.beers.stream()
                        .filter(s -> s.make().contains(q))
                        .toList() :
                this.beers;
    }

    @GET @Path("{id}") // ../beers/<een-id>
    public Beer get(@PathParam("id") String id) {
        return this.beers.get(Integer.parseInt(id));
    }

    @POST // ../beers
    public Beer add(BeerInput input) {
        Beer newBeer = new Beer(input.make(), input.type(), input.price());
        this.beers.add(newBeer);
        return newBeer;
    }
}
