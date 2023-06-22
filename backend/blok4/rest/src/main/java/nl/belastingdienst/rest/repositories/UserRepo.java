package nl.belastingdienst.rest.repositories;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;
import nl.belastingdienst.rest.domain.User;
import nl.belastingdienst.rest.util.PasswordUtils;

import static nl.belastingdienst.rest.domain.User.FIND_BY_USERNAME_AND_PASSWORD;

@Dependent // scope/lifetime/lifecycle is afhank. van de aanroeper
@Named("userrepo")
public class UserRepo extends Repo<User> {

    public User findByUsernameAndPassword(String login, String password) {
        TypedQuery<User> query = em.createNamedQuery(FIND_BY_USERNAME_AND_PASSWORD, User.class);
        query.setParameter("login", login);
        query.setParameter("password", PasswordUtils.digest(password));
        User user = query.getSingleResult();

        return user;
    }

    @Override public Class<User> E() { return User.class; }
}
