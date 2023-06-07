package nl.belastingdienst.rest.domain;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@XmlRootElement
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Beer {

    private int id = new Random().nextInt();
    private String make;
    private String type;
    private double price;

    public Beer(String make, String type, double p) {
        this.make = make;
        this.type = type;
        this.price = p;
    }
}
