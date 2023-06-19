package nl.belastingdienst.rest.resources.generified;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import nl.belastingdienst.rest.domain.User;
import nl.belastingdienst.rest.repositories.Repo;
import nl.belastingdienst.rest.repositories.UserRepo;
import nl.belastingdienst.rest.util.KeyGenerator;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.time.LocalDateTime.now;
import static nl.belastingdienst.rest.util.PasswordUtils.digest;

@Path("users")
public class UsersResource extends Resource<User> {

    @Context
    private UriInfo uriInfo;

    @Inject
    private KeyGenerator keyGenerator;

    @Inject @Named("userrepo")
    public void setRepo(Repo<User> repo) { this.repo = repo; }

    @POST
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public User register(User u) {
        u.setPassword(digest(u.getPassword()));
        getDao().add(u);
        return u;
    }

    @POST @Path("/login")
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public User login(User input) {
        try {
            String username = input.getUsername();
            String password = input.getPassword();

            User output = getDao().findByUsernameAndPassword(username, password);
            String jwt = issueToken(username);
            output.setToken(jwt);
            output.setPassword("");

            return output;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotAuthorizedException("User " + input + " is not authorized.");
        }
    }

    public UserRepo getDao() { return (UserRepo) this.repo; }

    private String issueToken(String username) {
        Key password = keyGenerator.generateKey();
        String jwt = Jwts.builder()
                .setSubject(username)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                // .setClaims(...) // roles toevoegen
                .setIssuedAt(new Date())
                .setExpiration(toDate(now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, password)
                .compact();
        // log.info("#### generated token: " + jwt);
        return jwt;
    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
