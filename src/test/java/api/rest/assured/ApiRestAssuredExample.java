package api.rest.assured;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ApiRestAssuredExample {

    @Test
    public void verifyPlanetaryApodPathResponse() {
        RestAssured.given().baseUri("https://api.nasa.gov")
                .queryParam("api_key", "CczxgRVC4BKeSEDoRFadfciJ6hF8d8tegw7mGBdK")
                .when().get("/planetary/apod")
                .then().statusCode(200)
                .and().assertThat().body(Matchers.containsString("date"));
    }

}
