package nl.belastingdienst.rest.domain;

import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = true)
@XmlRootElement
@Entity
public class Beer extends AbstractEntity<Integer> {

    private String make;
    private String type;
    private double price;

    public Beer(int id, String make, String type, double p) {
        this.make = make;
        this.type = type;
        this.price = p;
        this.id = id;
    }

    public static Beer of(int id, BeerInput b) {
        return Beer.builder().id(id)
                .make(b.make()).type(b.type()).price(b.price())
                .build();
    }
}
