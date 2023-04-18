package nl.bramjanssens.unittesting.faking.shopping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ShoppingCartMockitoTest {

    @Test
    void whenCheckoutOnExistingUserThenResultIsTrue() {
        // given
        UserDao mockUserDao = mock(UserDao.class);
        var target = new ShoppingCart(mockUserDao);
        when(mockUserDao.getUser(anyInt())).thenReturn(new User(1, "$Dummy"));

        // when
        boolean actual = target.checkout(42);

        // then
        assertTrue(actual);
        // verify that userDao.getUser is called?
        verify(mockUserDao).getUser(anyInt());
    }

    @Test
    void whenCheckoutOnIllegalUserIdThenExceptionIsThrown() {
        // given
        UserDao mockUserDao = mock(UserDao.class);
        var target = new ShoppingCart(mockUserDao);
        // when(mockUserDao.getUser(anyInt())).thenReturn(new User(1, "$Dummy"));
        when(mockUserDao.getUser(-1)).thenThrow(IllegalArgumentException.class);

        //                                   when
        // then
        assertThrows(RuntimeException.class, () -> target.checkout(-1));
        // verify that userDao.getUser is called?
        verify(mockUserDao).getUser(-1);
    }
}
