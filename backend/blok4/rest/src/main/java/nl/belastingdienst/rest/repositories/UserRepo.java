package nl.belastingdienst.rest.repositories;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.TypedQuery;
import nl.belastingdienst.rest.domain.User;
import nl.belastingdienst.rest.util.PasswordUtils;

@Dependent // scope/lifetime/lifecycle is afhank. van de aanroeper
public class UserRepo extends Repo<User> {

    public User findByUsernameAndPassword(String login, String password) {
        TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_LOGIN_PASSWORD, User.class);
        query.setParameter("login", login);
        query.setParameter("password", PasswordUtils.digestPassword(password));
        User user = query.getSingleResult();

        return user;
    }
}
