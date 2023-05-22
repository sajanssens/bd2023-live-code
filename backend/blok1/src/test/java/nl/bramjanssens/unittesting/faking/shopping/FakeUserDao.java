package nl.bramjanssens.unittesting.faking.shopping;

public class FakeUserDao implements UserDao {

    private boolean getUserIsCalled = false;

    @Override
    public User getUser(int id) {
        this.getUserIsCalled = true;
        return new User(id, "$Dummy");
    }

    public boolean verify() {
        return getUserIsCalled;
    }
}
