package nl.bramjanssens.unittesting.lab03.com.infosupport.shopping;

import nl.bramjanssens.unittesting.lab03.com.infosupport.shopping.service.BankingService;

import java.math.BigDecimal;

public class FakeBankingService implements BankingService {
    @Override
    public BigDecimal getBalance(String accountNumber) {
        return BigDecimal.valueOf(Long.MAX_VALUE);
    }

    @Override
    public void makePayment(String accountNumber, BigDecimal payment) {

    }
}
