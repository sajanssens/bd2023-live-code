package nl.bramjanssens.util

import jakarta.persistence.Persistence.createEntityManagerFactory

// Kotlin :-)
object MySql {

    private val emf = createEntityManagerFactory("MySQL")

    @JvmStatic fun connection() = emf
}

// Java:
// public static EntityManagerFactory connection() {
//     return Persistence.createEntityManagerFactory("MySQL");
// }

