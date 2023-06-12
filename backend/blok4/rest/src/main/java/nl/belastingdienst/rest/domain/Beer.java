package nl.belastingdienst.rest.domain;

import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.belastingdienst.rest.util.Id;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@XmlRootElement
@Entity
public class Beer {

    @jakarta.persistence.Id
    private int id = Id.next();
    private String make;
    private String type;
    private double price;

    public Beer(String make, String type, double p) {
        this.make = make;
        this.type = type;
        this.price = p;
    }
}
