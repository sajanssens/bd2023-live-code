package nl.bramjanssens.util

import jakarta.inject.Singleton
import jakarta.persistence.Persistence

// Kotlin :-)
@Singleton
class EntityManagerProducer {

    // Kotlin's static:
    companion object MySQL {
        private val entityManagerFactory = Persistence.createEntityManagerFactory("MySQL")

        fun connection(): jakarta.persistence.EntityManagerFactory = entityManagerFactory
    }

    // Java:
    // @Produces
    // public static EntityManagerFactory emf() {
    //     return Persistence.createEntityManagerFactory("MySQL");
    // }
}
