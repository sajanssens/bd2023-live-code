package nl.belastingdienst;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import nl.belastingdienst.rest.domain.Beer;
import nl.belastingdienst.rest.domain.User;
import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jupiter.MicroShedTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicroShedTest
@SharedContainerConfig(AppDeploymentConfig.class)
public class AppIT {

    private static final Gson gson = new GsonBuilder().create();

    @Test
    void whenPostOnAuthorizedEndpoint401IsReturned() {
        Beer beer = Beer.builder().make("Leffe").type("Quadrupel").price(2.89).build();
        given().contentType("application/json").body(gson.toJson(beer))
                .when().post("/api/beers")
                .then().statusCode(401);
    }

    @Test
    void whenBeerIsAddedGetBeersIsNotNull() {
        String token = login();
        var beer = Beer.builder().make("Leffe").type("Quadrupel").price(2.89).build();

        given().contentType("application/json").header("Authorization", "Bearer " + token).body(gson.toJson(beer))
                .when().post("/api/beers")
                .then().statusCode(200);

        var resp = given()
                .when().get("/api/beers")
                .then().statusCode(200)
                .extract().response();

        assertNotNull(resp.getBody());
    }

    private static String login() {
        var u = User.builder().username("admin").password("admin").build();
        Response resp = given().contentType("application/json").body(gson.toJson(u))
                .when().post("/api/users/login")
                .then().statusCode(200).extract().response();

        User user = gson.fromJson(resp.getBody().print(), User.class);
        return user.getToken();
    }
}
