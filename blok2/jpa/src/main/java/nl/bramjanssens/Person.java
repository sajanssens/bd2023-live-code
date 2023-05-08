package nl.bramjanssens;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data @NoArgsConstructor @Builder @AllArgsConstructor // lombok
@Entity
@NamedQuery(name = "Person.findAll", query = "select p from Person p")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @Basic
    private String name;

    // @Basic
    private int age;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team mijnTeam;

    @ManyToOne
    private Department afdelingWaarIkWerk;

    // @ElementCollection @Builder.Default
    // private ArrayList<Rol> rollen = new ArrayList<>();

    public void setAfdelingWaarIkWerk(Department afdelingWaarIkWerk) {
        this.afdelingWaarIkWerk = afdelingWaarIkWerk;
        afdelingWaarIkWerk.getEmployees().add(this);
    }
}
