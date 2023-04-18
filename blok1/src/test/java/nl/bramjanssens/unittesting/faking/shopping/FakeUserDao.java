package nl.bramjanssens.unittesting.faking.shopping;

public class FakeUserDao implements UserDao {

    @Override
    public User getUser(int id) {
        return new User(id, "$Dummy");
    }
}
