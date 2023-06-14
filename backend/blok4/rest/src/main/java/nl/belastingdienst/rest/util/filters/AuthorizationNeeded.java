package nl.belastingdienst.rest.util.filters;

import io.jsonwebtoken.Jwts;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import nl.belastingdienst.rest.util.KeyGenerator;

import java.security.Key;

import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static jakarta.ws.rs.core.Response.Status.UNAUTHORIZED;
import static jakarta.ws.rs.core.Response.status;

@Provider
@Authorized
@Priority(Priorities.AUTHENTICATION)
// @Slf4j
public class AuthorizationNeeded implements ContainerRequestFilter {

    @Inject
    private KeyGenerator keyGenerator;

    @Override
    public void filter(ContainerRequestContext req) {

        // Get the HTTP Authorization header from the request
        String authorizationHeader = req.getHeaderString(AUTHORIZATION);
        // log.info("#### authorizationHeader : " + authorizationHeader);

        // Check if the HTTP Authorization header is present and formatted correctly
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            // log.warn("#### invalid authorizationHeader : " + authorizationHeader);
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {
            // Validate the token
            Key key = keyGenerator.generateKey();
            Jwts.parser().setSigningKey(key).parseClaimsJws(token); // valideer het token: is hij geldig?
            // log.info("#### valid token : " + token);
        } catch (Exception e) {
            // log.warn("#### invalid token : " + token);
            req.abortWith(status(UNAUTHORIZED).build());
        }
    }
}
