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
import nl.belastingdienst.rest.repositories.BeerFakeRepo;
import nl.belastingdienst.rest.repositories.BeerJPARepo;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("beers") // @RequestScoped
public class BeersResource {

    @Inject
    private BeerFakeRepo repo;

    @Inject
    private BeerJPARepo jpaRepo;

    @Inject
    private BeerResource beerResource;

    @GET  // .../beers?q=leffe
    @Produces({APPLICATION_JSON}) // ask by using header `Accept: application/json` or `Accept: application/xml`
    public List<Beer> search(@QueryParam("q") String q) {
        return q != null ?
                this.jpaRepo.findByMake(q) :
                this.jpaRepo.getAll();
    }

    @POST // .../beers
    @Produces({APPLICATION_JSON}) @Consumes(APPLICATION_JSON)
    public Beer add(BeerInput input) {
        Beer newBeer = Beer.of(input);
        this.jpaRepo.add(newBeer);
        return newBeer;
    }

    // Delegate all requests on a single beer to sub-resource `BeerResource` : ----------------

    @Path("{id}") // .../beers/<an-id>
    public BeerResource beer(@PathParam("id") int id) {
        System.out.println("beer" + id);
        return this.beerResource.with(id);
    }

    // @Path("{id}") // .../beers/<an-id>
    // public BeerResource delete(@PathParam("id") int id) { return beerResource.with(id); }
    //
    // @Path("{id}") // ../beers/<an-id>
    // public BeerResource edit(@PathParam("id") int id) { return beerResource.with(id); }

    @Path("{id}/recipes") // .../beers/<an-id>/recipes
    public BeerResource getBeerRecipes(@PathParam("id") int id) { return beerResource.with(id); }

    @Path("{id}/recipes/{rid}") // .../beers/<an-id>/recipes/<an-rid>
    public BeerResource getBeerRecipe(@PathParam("id") int id) { return beerResource.with(id); }
}

