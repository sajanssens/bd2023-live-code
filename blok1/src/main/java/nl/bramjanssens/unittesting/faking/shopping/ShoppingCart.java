package nl.bramjanssens.unittesting.faking.shopping;

public class ShoppingCart {

    // field injection (with e.g. @Inject and DI-framework)
    private UserDao userDao;

    // constructor injection
    public ShoppingCart(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkout(int userId) {
        User user = userDao.getUser(userId);

        if (user.name().startsWith("$")) {
            return true;
        } else {
            return false;
        }
    }

    // setter injection
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
