package nl.bramjanssens.mutationtesting;

public record Customer(String name, int age) {
    public boolean isAllowedToBuyAlcohol(Customer customer) {
        return age() >= 18;
    }
}
