package nl.belastingdienst;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import nl.belastingdienst.rest.domain.Beer;
import nl.belastingdienst.rest.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jupiter.MicroShedTest;

import static io.restassured.RestAssured.given;

@MicroShedTest
@SharedContainerConfig(AppDeploymentConfig.class)
public class AppIT {

    static Gson gson = new GsonBuilder().create();

    @Test
    void whenPostOnAuthorizedEndpoint401IsReturned() {
        Beer beer = Beer.builder().make("Leffe").type("Quadrupel").price(2.89).build();
        given().contentType("application/json").body(gson.toJson(beer))
                .when().post("/api/beers")
                .then().statusCode(401);
    }

    @Test @Disabled // TODO: add login and get/use jwt
    void whenBeerIsAddedGetBeersIsNonZero() {
        User u = User.builder().username("admin").password("admin").build();
        Response resp = given().contentType("application/json").body(gson.toJson(u))
                .when().post("/api/users/login")
                .then().statusCode(200).extract().response();

        User user = gson.fromJson(resp.getBody().print(), User.class);
        String token = user.getToken();

        Beer beer = Beer.builder().make("Leffe").type("Quadrupel").price(2.89).build();
        given().contentType("application/json").header("Authorization", "Bearer " + token).body(gson.toJson(beer))
                .when().post("/api/beers")
                .then().statusCode(201);

        resp = given().when().get("/api/beers").then().extract().response();

        Assertions.assertNotNull(resp.getBody());
    }
}
