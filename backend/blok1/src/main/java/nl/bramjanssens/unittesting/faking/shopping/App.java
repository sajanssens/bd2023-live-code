package nl.bramjanssens.unittesting.faking.shopping;

public class App {

    public static void main(String[] args) {
        boolean checkout = new ShoppingCart(new RealUserDao()).checkout(1);
        System.out.println(checkout);
    }
}
