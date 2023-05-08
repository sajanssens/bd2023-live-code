package nl.bramjanssens;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @Builder @AllArgsConstructor // lombok
@Entity
@Table(name = "Afdeling")
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "afdelingsnaam")
    private String name;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "afdelingWaarIkWerk")
    @Builder.Default // voor lombok
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Person> employees = new ArrayList<>();
}
