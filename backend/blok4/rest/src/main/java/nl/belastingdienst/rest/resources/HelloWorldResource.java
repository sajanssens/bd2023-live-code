package nl.belastingdienst.rest.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import nl.belastingdienst.rest.util.NoHelloFoundException;

@Path("helloworld")
public class HelloWorldResource {

    @GET
    public Response hello() {
        boolean notFound = false    ;
        if (notFound)
            return Response
                    .status(403)
                    .build();
        else
            return Response
                    .status(200)
                    .entity("HELLO!")
                    .build();
    }

    // unreachable rest endpoint
    @GET
    public String helloJson() {
        boolean notFound = true;
        if (notFound) throw new NoHelloFoundException("hello is niet gevonden...");
        return "helloJson!";
    }
}
