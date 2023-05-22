package nl.bramjanssens.unittesting.faking.shopping;

public class ShoppingCart {

    // field injection (with e.g. @Inject and DI-framework)
    private final UserDao userDao;

    // constructor injection
    public ShoppingCart(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkout(int userId) {
        try {
            User user = userDao.getUser(userId);

            if (user.name().startsWith("$")) {
                return true;
            } else {
                return false;
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
