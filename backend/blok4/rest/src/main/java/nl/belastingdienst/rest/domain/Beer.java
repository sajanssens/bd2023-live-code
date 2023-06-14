package nl.belastingdienst.rest.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
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
@NamedQuery(name = "Beer.findAll", query = "select b from Beer b")
@Table(name = "Beer")
public class Beer extends AbstractEntity<Integer> {

    @Lob
    private String make;
    private String type;
    private double price;

    public Beer(int id, String make, String type, double p) {
        this.make = make;
        this.type = type;
        this.price = p;
        this.id = id;
    }

    public static Beer of(Integer id, BeerInput b) {
        return Beer.builder().id(id)
                .make(b.make()).type(b.type()).price(b.price())
                .build();
    }

    public static Beer of(BeerInput b) {
        return of(null, b);
    }
}
