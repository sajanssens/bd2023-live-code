package nl.belastingdienst.rest.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@MappedSuperclass
@Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
public abstract class AbstractEntity<I extends Serializable> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected I id;

    @Version // voor optimistic locking
    protected long version;

    @Transient
    protected String _self;
}
