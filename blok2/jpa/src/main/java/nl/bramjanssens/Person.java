package nl.bramjanssens;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
    private Team mijnVoetbalteam;
}
