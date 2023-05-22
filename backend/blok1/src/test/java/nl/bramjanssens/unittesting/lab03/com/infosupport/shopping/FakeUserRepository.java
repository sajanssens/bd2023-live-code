package nl.bramjanssens.unittesting.lab03.com.infosupport.shopping;

import nl.bramjanssens.unittesting.lab03.com.infosupport.shopping.repository.UserRepository;

import java.math.BigDecimal;

public class FakeUserRepository implements UserRepository {

    // Verplichte methodes uit de interface:

    @Override
    public User getUser(String username) {
        return new User(username, null, null);
    }

    @Override
    public void addPaymentHistory(String username, BigDecimal payment) {
        isInteractedWith = true;
        // payments.add(new Payment(username, payment));
    }

    // Fake spul dat ik nodig heb:

    private boolean isInteractedWith = false;

    public boolean verify() { return isInteractedWith; }

    // private final List<Payment> payments = new ArrayList<>();
    //
    // public List<Payment> getPayments() { return payments; }
    //
    // record Payment(String user, BigDecimal amount) { }
}
