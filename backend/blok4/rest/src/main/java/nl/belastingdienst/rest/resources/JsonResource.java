package nl.belastingdienst.rest.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public interface JsonResource { }
