package nl.belastingdienst.rest.domain;

import java.util.UUID;

public record Beer(String id, String name) {

    public Beer(String name) {
        this(UUID.randomUUID().toString(), name);
    }
}
