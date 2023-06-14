package nl.belastingdienst.rest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.lastName DESC"),
        @NamedQuery(name = User.FIND_BY_LOGIN_PASSWORD, query = "SELECT u FROM User u WHERE u.username = :login AND u.password = :password")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@SuperBuilder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity<Integer> {

    public static final String FIND_BY_LOGIN_PASSWORD = "User.findByLoginAndPassword";

    private String lastName;
    private String firstName;

    @Column(length = 10, nullable = false)
    private String username;

    @Column(length = 256, nullable = false)
    private String password;

    private String token;
}
