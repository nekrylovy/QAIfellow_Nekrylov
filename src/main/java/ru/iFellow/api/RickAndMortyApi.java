package ru.iFellow.api;

import io.restassured.response.ValidatableResponse;
import ru.iFellow.config.RickAndMortyConfig;

import static io.restassured.RestAssured.given;

public class RickAndMortyApi extends BaseApi {
    private static final RickAndMortyConfig config = new RickAndMortyConfig();

    public RickAndMortyApi() {
        super(config.getURL());
    }

    public ValidatableResponse getCharacters() {
        return given()
                .when()
                .get(config.getCHARACTERS_URN())
                .then();
    }

    public ValidatableResponse get(String url) {
        return given()
                .when()
                .get(url)
                .then()
                .log()
                .body();
    }
}
