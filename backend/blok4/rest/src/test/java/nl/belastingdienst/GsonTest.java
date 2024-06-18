package nl.belastingdienst;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GsonTest {

    @Test
    void gson() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        LocalDate now = LocalDate.now();
        String json = gson.toJson(new Person("Bram", now));

        assertTrue(json.contains(now.toString()));
    }
}

record Person(String name, LocalDate birthday) implements Serializable { }

