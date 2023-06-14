package nl.belastingdienst.rest.resources;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import nl.belastingdienst.rest.domain.Beer;
import nl.belastingdienst.rest.domain.BeerInput;
import nl.belastingdienst.rest.repositories.BeerFakeRepo;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Dependent // Deze is injecteerbaar (als discovery-mode=annotated).
//            De levensduur van deze CDI-bean is hetzelfde (dependent) als de klasse waarin hij geïnjecteerd wordt.
@Produces({APPLICATION_JSON/*, APPLICATION_XML*/}) // ask by using header `Accept: application/json` or `Accept: application/xml`
@Consumes(APPLICATION_JSON)
// No @Path in a subresource!
// This runs @ beers/{id}
public class BeerResource {

    @Inject
    private BeerFakeRepo repo;

    private int id;

    public BeerResource() { /* for CDI */ }

    @GET// .../beers/<een-id>
    public Beer get(@Context UriInfo uri) {
        Beer beer = this.repo.get(this.id);
        beer.set_self(uri.getAbsolutePath().toString());
        return beer;
    }

    @PUT// .../beers/<een-id>
    public Beer edit(BeerInput input) {
        System.out.println("beer:" + id + ", input: " + input);
        Beer editedBeer = Beer.of(id, input);
        this.repo.getEm().remove(this.repo.get(this.id));
        this.repo.getEm().add(editedBeer);
        return editedBeer;
    }

    @DELETE // .../beers/<een-id>
    public void delete() {
        boolean removed = this.repo.getEm().remove(this.repo.get(this.id));
        if (!removed) throw new BadRequestException();
    }

    @GET @Path("recipes") // .../beers/<een-id>/recipes
    public Beer getBeerRecipes() {
        throw new RuntimeException("NotImplemented");
    }

    @GET @Path("recipes/{rid}") // .../beers/<een-id>/recipes/<een-rid>
    public Beer getBeerRecipe(@PathParam("rid") int rid) {
        throw new RuntimeException("NotImplemented");
    }

    public BeerResource with(int id) {
        this.id = id;
        return this;
    }
}

