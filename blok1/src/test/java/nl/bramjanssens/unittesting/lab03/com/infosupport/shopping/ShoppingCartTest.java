package nl.bramjanssens.unittesting.lab03.com.infosupport.shopping;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    private final Product xbox = new Product("Xbox 360", new BigDecimal("199.99"));
    private final Product playstation = new Product("PlayStation3", new BigDecimal(250));

    @Test
    public void add_oneProduct_shouldAddProductToCart() {
        // Arrange
        var sut = new ShoppingCart("Frank");

        // Act
        sut.add(xbox, 2);

        // Assert
        assertProductIsInCart(sut, xbox, 2);
    }

    @Test
    public void add_twiceSameProduct_shouldAddToExistingAmount() {
        var sut = new ShoppingCart("Frank");
        sut.add(xbox, 2);
        sut.add(xbox, 3);
        assertProductIsInCart(sut, xbox, 5);
    }

    @Test
    public void add_twoDifferentProducts_shouldAddBothToCart() {
        var sut = new ShoppingCart("Frank");
        sut.add(xbox, 1);
        sut.add(playstation, 2);
        assertProductIsInCart(sut, xbox, 1);
        assertProductIsInCart(sut, playstation, 2);
    }

    @Test
    public void getTotal_emptyCart_shouldBeZero() {
        var sut = new ShoppingCart("Frank");
        assertEquals(BigDecimal.ZERO, sut.getTotal());
    }

    @Test
    public void getTotal_twoProductsWithDifferentAmount_shouldCalculateCorrectTotal() {
        var sut = new ShoppingCart("Frank");
        sut.add(playstation, 2); // 500
        sut.add(xbox, 1); // 199.99
        assertEquals(new BigDecimal("699.99"), sut.getTotal());
    }

    private void assertProductIsInCart(ShoppingCart sut, Product expectedItem, int expectedAmount) {
        assertTrue(sut.getOrders().containsKey(expectedItem));
        assertEquals(expectedAmount, sut.getOrders().get(expectedItem));
    }

    @Test
    public void checkout_callsUserRepository() {
        // given
        FakeUserRepository userRepository = new FakeUserRepository();
        // FakeBankingService bankingService = new FakeBankingService();
        var sut = new ShoppingCart("FRANK", userRepository, null);
        sut.add(playstation, 1);
        sut.add(xbox, 4);

        // when
        sut.checkOut();

        // then
        assertTrue(userRepository.verify());

        // assertEquals(1, userRepository.getPayments().size());
        //
        // FakeUserRepository.Payment payment = userRepository.getPayments().get(0);
        // assertEquals("FRANK", payment.user());
        // assertEquals(valueOf(1199.99), payment.amount());
    }

    @Test
    public void checkout_sufficientBalance_addsToPaymentHistory() {
        // given
        FakeUserRepository userRepository = new FakeUserRepository();
        FakeBankingService bankingService = new FakeBankingService();
        var sut = new ShoppingCart("FRANK", userRepository, bankingService);
        sut.add(playstation, 1);
        sut.add(xbox, 4);

        // when
        sut.checkOut();

        // then
        // assertEquals(1, userRepository.getPayments().size());

        // FakeUserRepository.Payment payment = userRepository.getPayments().get(0);
        // assertEquals("FRANK", payment.user());
        // assertEquals(valueOf(1199.99), payment.amount());
    }
}
