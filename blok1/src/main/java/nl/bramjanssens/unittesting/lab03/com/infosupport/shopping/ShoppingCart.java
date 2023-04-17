package nl.bramjanssens.unittesting.lab03.com.infosupport.shopping;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> orders = new HashMap<>();
    private String owner;

    public String getOwner() {
        return owner;
    }

    public Map<Product, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }

    public ShoppingCart(String username) {
        owner = username;
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
        // TODO: Implement
    }
}
