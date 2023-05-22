package nl.bramjanssens.unittesting.faking.shopping;

public class RealUserDao implements UserDao {

    public User getUser(int userId) {
        // TODO: get from database...
        throw new RuntimeException("No database connection...");
    }
}
