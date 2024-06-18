package nl.belastingdienst;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GsonTest {

    @Test
    void gson() {
        Gson gson = new GsonBuilder()
                // .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        System.out.println(gson.toJson(new Person("Bram", LocalDate.now())));
    }
}
record Person(String name, LocalDate birthday) implements Serializable {}

