package nl.bramjanssens.unittesting.faking.shopping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingCartTest {

    @Test
    void whenCheckoutOnExistingUserThenResultIsTrue() {
        // given
        FakeUserDao userDao = new FakeUserDao();
        var target = new ShoppingCart(userDao);

        // when
        boolean actual = target.checkout(42);

        // then
        assertTrue(actual);
        // verify that userDao.getUser is called?
        assertTrue(userDao.verify());
    }
}
