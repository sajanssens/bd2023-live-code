package nl.belastingdienst.rest.repositories;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import nl.belastingdienst.rest.domain.User;

import static nl.belastingdienst.rest.domain.User.FIND_BY_USERNAME_AND_PASSWORD;
import static nl.belastingdienst.rest.util.PasswordUtils.digest;

@Dependent // scope/lifetime/lifecycle is afhank. van de aanroeper
@Named("userrepo")
public class UserRepo extends Repo<User> {

    public User findByUsernameAndPassword(String login, String password) {
        return em.createNamedQuery(FIND_BY_USERNAME_AND_PASSWORD, User.class)
                .setParameter("login", login)
                .setParameter("password", digest(password))
                .getSingleResult();
    }

    @Override public Class<User> E() { return User.class; }
}
