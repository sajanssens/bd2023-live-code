package nl.bramjanssens.unittesting.faking.shopping;

import nl.bramjanssens.unittesting.faking.person.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShoppingCartMockitoTest {

    @Mock
    private UserDao mockUserDao;
    
    @InjectMocks // 1) instance maken van ShoppingCart en 2) daarin de mocks die hierboven staan injecteren.
    private ShoppingCart target;

    @Test
    void whenCheckoutOnExistingUserThenResultIsTrue() {
        // given
        when(mockUserDao.getUser(anyInt())).thenReturn(new User(1, "$Dummy"));

        // when
        boolean actual = target.checkout(42);

        // then
        assertTrue(actual);
        verify(mockUserDao).getUser(anyInt());
    }

    @Test
    void whenCheckoutOnIllegalUserIdThenExceptionIsThrown() {
        // given
        when(mockUserDao.getUser(-1)).thenThrow(IllegalArgumentException.class);

        //                                   when
        // then
        assertThrows(RuntimeException.class, () -> target.checkout(-1));
        // verify that userDao.getUser is called?
        verify(mockUserDao).getUser(-1);
    }
}
