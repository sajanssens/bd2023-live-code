package nl.belastingdienst.rest.resources.generified;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import nl.belastingdienst.rest.domain.JPAEntity;
import nl.belastingdienst.rest.repositories.Repo;

import java.util.Collection;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

public abstract class Resource<E extends JPAEntity> {

    protected Repo<E> repo;

    public abstract void setRepo(Repo<E> repo);

    @GET
    @Produces(APPLICATION_JSON)
    public Collection<E> getAll(@QueryParam("q") String q) {
        return q == null ? repo.getAll() : repo.getByQ(q);
    }

    @GET @Path("{id}")
    @Produces(APPLICATION_JSON)
    public E get(@PathParam("id") Integer id) {
        return repo.get(id);
    }

    @POST
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public E post(E e) {
        if (repo.add(e) != null) {
            return e;
        } else {
            throw new RuntimeException("Post " + e + " failed.");
        }
    }

    @DELETE @Path("{id}")
    public void delete(@PathParam("id") String id) {
        if (!repo.remove(id)) {
            throw new BadRequestException("Delete with id " + id + " failed.");
        }
    }

    @PUT @Path("{id}")
    public E put(@PathParam("id") Integer id, E e) {
        return repo.update(id, e);
    }
}
