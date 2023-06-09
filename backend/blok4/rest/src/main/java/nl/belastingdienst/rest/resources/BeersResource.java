package nl.belastingdienst.rest.resources;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import lombok.extern.slf4j.Slf4j;
import nl.belastingdienst.rest.domain.Beer;
import nl.belastingdienst.rest.domain.BeerInput;
import nl.belastingdienst.rest.domain.Role;
import nl.belastingdienst.rest.repositories.Repo;
import nl.belastingdienst.rest.util.BEER;

import java.util.Collection;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("beers") // @RequestScoped
@Slf4j
@DeclareRoles({Role.USER, Role.ADMIN})
public class BeersResource {

    @Inject @BEER
    private Repo<Beer> repo;

    @Inject
    private BeerResource beerResource;

    @GET  // .../beers?q=leffe
    @Produces(APPLICATION_JSON) // ask by using header `Accept: application/json` or `Accept: application/xml`
    public Collection<Beer> search(@QueryParam("q") String q) {
        log.info("searching...");
        return q != null ?
                this.repo.getByQ(q) :
                this.repo.getAll();
    }

    @POST // .../beers
    @RolesAllowed(Role.ADMIN)
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public Beer add(BeerInput input) {
        return this.repo.add(Beer.of(input));
    }

    // Delegate all requests on a single beer to sub-resource `BeerResource` : ----------------

    @Path("{id}") // .../beers/<an-id>
    public BeerResource beer(@PathParam("id") int id) { return this.beerResource.with(id); }

    @Path("{id}/recipes") // .../beers/<an-id>/recipes
    public BeerResource getBeerRecipes(@PathParam("id") int id) { return beerResource.with(id); }

    @Path("{id}/recipes/{rid}") // .../beers/<an-id>/recipes/<an-rid>
    public BeerResource getBeerRecipe(@PathParam("id") int id, @PathParam("rid") int rid) { return beerResource.with(id, rid); }
}

