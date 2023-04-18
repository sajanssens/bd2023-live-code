package nl.bramjanssens.unittesting.lab03.com.infosupport.shopping;

import nl.bramjanssens.unittesting.lab03.com.infosupport.shopping.repository.UserRepository;
import nl.bramjanssens.unittesting.lab03.com.infosupport.shopping.service.BankingService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private UserRepository userRepository;
    private BankingService bankingService;

    private Map<Product, Integer> orders = new HashMap<>();
    private String owner;

    public ShoppingCart(String username) {
        owner = username;
    }

    public ShoppingCart(String username, UserRepository userRepository, BankingService bankingService) {
        owner = username;
        orders = new HashMap<>();

        this.userRepository = userRepository;
        this.bankingService = bankingService;
    }

    public String getOwner() {
        return owner;
    }

    public Map<Product, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }

    /**
     * Add a new item to this cart.
     * When the item is already in the list, only the amount should be increased
     * and no new item added.
     *
     * @param item   the item to add
     * @param amount The amount for this item to be added.
     */
    public void add(Product item, int amount) {
        if (orders.containsKey(item)) {
            orders.put(item, orders.get(item) + amount);
        } else {
            orders.put(item, amount);
        }
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (var product : orders.keySet()) {
            total = total.add(product.price().multiply(BigDecimal.valueOf(orders.get(product))));
        }
        return total;
    }

    public void checkOut() {
        User user = userRepository.getUser(owner);
        // BigDecimal balance = bankingService.getBalance(user.accountNumber());
        // if (balance.floatValue() >= getTotal().floatValue()) {
        // bankingService.makePayment(user.accountNumber(), getTotal());
        userRepository.addPaymentHistory(user.name(), getTotal());
        // }
    }
}
