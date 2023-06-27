package nl.belastingdienst.rest.resources.generified;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import nl.belastingdienst.rest.domain.Role;
import nl.belastingdienst.rest.domain.User;
import nl.belastingdienst.rest.repositories.Repo;
import nl.belastingdienst.rest.repositories.UserRepo;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static io.smallrye.jwt.util.KeyUtils.readPrivateKey;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.MINUTES;
import static nl.belastingdienst.rest.util.PasswordUtils.digest;

@Path("users")
public class UsersResource extends Resource<User> {

    @Inject @Named("userrepo")
    public void setRepo(Repo<User> repo) { this.repo = repo; }

    @RolesAllowed(Role.ADMIN)
    @POST
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public User register(User u) {
        u.setPassword(digest(u.getPassword()));
        return getDao().add(u);
    }

    @POST @Path("login")
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public User login(User input) {
        try {
            String username = input.getUsername();
            String password = input.getPassword();

            User user = getDao().findByUsernameAndPassword(username, password);
            String jwt = issueToken(user);
            user.setToken(jwt);
            user.setPassword("");

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotAuthorizedException("User " + input + " is not authorized.");
        }
    }

    private String issueToken(User user) throws GeneralSecurityException, IOException {
        return Jwt.issuer("bramjanssens")
                .subject("rest-demo-app")
                .upn(user.getLastName())
                .claim("username", user.getUsername())
                .groups(user.getRoles())
                .issuedAt(now())
                .expiresAt(now().plus(30, MINUTES))
                .sign(readPrivateKey("private-key.pem"));
    }

    public UserRepo getDao() { return (UserRepo) this.repo; }
}
