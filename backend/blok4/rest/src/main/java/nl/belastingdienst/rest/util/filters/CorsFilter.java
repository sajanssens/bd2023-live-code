package nl.belastingdienst.rest.util.filters;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.util.StringJoiner;

import static jakarta.ws.rs.HttpMethod.DELETE;
import static jakarta.ws.rs.HttpMethod.GET;
import static jakarta.ws.rs.HttpMethod.HEAD;
import static jakarta.ws.rs.HttpMethod.OPTIONS;
import static jakarta.ws.rs.HttpMethod.POST;
import static jakarta.ws.rs.HttpMethod.PUT;
import static org.apache.hc.core5.http.HttpHeaders.ACCEPT;
import static org.apache.hc.core5.http.HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS;
import static org.apache.hc.core5.http.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
import static org.apache.hc.core5.http.HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS;
import static org.apache.hc.core5.http.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static org.apache.hc.core5.http.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;
import static org.apache.hc.core5.http.HttpHeaders.AUTHORIZATION;
import static org.apache.hc.core5.http.HttpHeaders.CONTENT_TYPE;
import static org.apache.hc.core5.http.HttpHeaders.REFERER;

@Provider // register this filter with JAX-RS
public class CorsFilter implements ContainerResponseFilter {

    private static final String origin = "http://localhost:4200";
    private static final String methods = new StringJoiner(", ").add(GET).add(POST).add(PUT).add(DELETE).add(OPTIONS).add(HEAD).toString();
    private static final String headers = new StringJoiner(", ").add(REFERER).add(CONTENT_TYPE).add(ACCEPT).add(AUTHORIZATION).toString();

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) {
        var h = response.getHeaders();

        h.add(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
        h.add(ACCESS_CONTROL_ALLOW_METHODS, methods);
        h.add(ACCESS_CONTROL_ALLOW_CREDENTIALS, true); // allows the browser to accept Auhorization header.
        h.add(ACCESS_CONTROL_ALLOW_HEADERS, headers);
        h.add(ACCESS_CONTROL_EXPOSE_HEADERS, AUTHORIZATION); // so scripts are allowed to read this header(s)
    }
}
