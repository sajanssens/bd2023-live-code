package nl.belastingdienst.rest.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import nl.belastingdienst.rest.domain.Beer;
import nl.belastingdienst.rest.domain.BeerInput;
import nl.belastingdienst.rest.repositories.BeerRepo;

import java.util.List;
import java.util.Map;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.APPLICATION_XML;
import static java.util.Collections.singletonMap;

@Path("beers")
public class BeersResource {

    @Inject
    private BeerRepo repo;

    @Inject
    private BeerResource beerResource;

    @GET  // .../beers?q=leffe
    @Produces({APPLICATION_JSON, APPLICATION_XML}) // ask by using header `Accept: application/json` or `Accept: application/xml`
    public Map<String, List<Beer>> search(@QueryParam("q") String q) {
        return q != null ?
                singletonMap("beers", this.repo.getBeers().stream()
                        .filter(s -> s.getMake().toLowerCase().contains(q.toLowerCase()))
                        .filter(s -> s.getType().toLowerCase().contains(q.toLowerCase()))
                        .toList()) :
                singletonMap("beers", this.repo.getBeers());
    }

    @POST // .../beers
    @Produces({APPLICATION_JSON}) @Consumes(APPLICATION_JSON)
    public Beer add(BeerInput input) {
        Beer newBeer = new Beer(input.make(), input.type(), input.price());
        this.repo.getBeers().add(newBeer);
        return newBeer;
    }

    // Delegate all requests on a single beer to sub-resource `BeerResource` : ----------------

    @Path("{id}") // .../beers/<an-id>
    public BeerResource delete(@PathParam("id") int id) { return beerResource.with(id); }

    @Path("{id}") // .../beers/<an-id>
    public BeerResource get(@PathParam("id") int id) { return beerResource.with(id); }

    @Path("{id}") // ../beers/<an-id>
    public BeerResource edit(@PathParam("id") int id) { return beerResource.with(id); }

    @Path("{id}/recipes") // .../beers/<an-id>/recipes
    public BeerResource getBeerRecipes(@PathParam("id") int id) { return beerResource.with(id); }

    @Path("{id}/recipes/{rid}") // .../beers/<an-id>/recipes/<an-rid>
    public BeerResource getBeerRecipe(@PathParam("id") int id) { return beerResource.with(id); }
}

