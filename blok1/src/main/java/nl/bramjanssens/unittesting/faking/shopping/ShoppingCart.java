package nl.bramjanssens.unittesting.faking.shopping;

public class ShoppingCart {

    public boolean checkout(int userId) {
        RealUserDao dao = new RealUserDao();

        User user = dao.getUser(userId);

        if (user.name().startsWith("$")) {
            return true;
        } else {
            return false;
        }
    }
}
