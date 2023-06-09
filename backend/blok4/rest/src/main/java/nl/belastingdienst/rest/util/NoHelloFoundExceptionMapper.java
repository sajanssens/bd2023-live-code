package nl.belastingdienst.rest.util;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoHelloFoundExceptionMapper implements ExceptionMapper<NoHelloFoundException> {

    // Als er ergens in mijn JAX-RS-app een NoHelloFoundException optreedt
    // vang ik hem hier af:
    @Override
    public Response toResponse(NoHelloFoundException ex) {
        // dit is als het ware de catch(BadRequestException ex){
        return Response.status(403)
                .entity("NoHelloFoundExceptionMapper: " + ex.getMessage())
                .build();
        //}
    }
}
