package nl.belastingdienst.rest.domain;

import java.util.Random;

public record Beer(int id, String make, String type, double price) {

    public Beer(String make, String type, double price) {
        this(new Random().nextInt(), make, type, price);
    }
}
