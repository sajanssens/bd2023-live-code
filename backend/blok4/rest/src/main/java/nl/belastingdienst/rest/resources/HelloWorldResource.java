package nl.belastingdienst.rest.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("helloworld")
public class HelloWorldResource {

    @GET
    public String hello() {
        return "HELLO!";
    }

    // unreachable rest endpoint
    @GET
    public String helloJson() {
        return "helloJson!";
    }

}
