package nl.bramjanssens.unittesting.lab03.com.infosupport.shopping.repository;

import nl.bramjanssens.unittesting.lab03.com.infosupport.shopping.User;

import java.math.BigDecimal;

public interface UserRepository {
    User getUser(String username);

    void addPaymentHistory(String username, BigDecimal payment);
}
