package nl.bramjanssens.util

import jakarta.inject.Singleton
import jakarta.persistence.Persistence

// Kotlin :-)
@Singleton
class EntityManagerProducer {

    companion object MySQL {
        private val entityManagerFactory = Persistence.createEntityManagerFactory("MySQL")

        fun connection(): jakarta.persistence.EntityManagerFactory = entityManagerFactory
    }

    // Java:
    // @Produces
    // public EntityManager emf() {
    //     return Persistence.createEntityManagerFactory("MySQL");
    // }
}
