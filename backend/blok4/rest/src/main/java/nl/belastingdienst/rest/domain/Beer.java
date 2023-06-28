package nl.belastingdienst.rest.domain;

import jakarta.persistence.Entity;
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
@NamedQuery(name = "Beer.search", query = "select b from Beer b where b.make like :q OR b.type like :q")
@Table(name = "Beer")
public class Beer extends JPAEntity {

    private String make;
    private String type;
    private double price;

    public Beer(int id, String make, String type, double p) {
        this.make = make;
        this.type = type;
        this.price = p;
        this.id = id;
    }

    public static Beer of(BeerInput b) {
        return Beer.builder()
                .make(b.make()).type(b.type()).price(b.price())
                .build();
    }

    public Beer merge(BeerInput input) {
        setMake(input.make());
        setType(input.type());
        setPrice(input.price());
        return this;
    }
}
