package ru.iFellow.api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RickAndMortyApi extends BaseApi {

    private static final String CHARACTERS_URN = "/character";
    private static final String EPISODE_URN = "/episode";

    public RickAndMortyApi() {
        super("https://rickandmortyapi.com/api");
    }

    public ValidatableResponse getCharacter() {
        return given()
                .when()
                .get(CHARACTERS_URN)
                .then();
    }

    public ValidatableResponse getCharacter(int id) {
        return given()
                .when()
                .get(CHARACTERS_URN + "/" + id)
                .then();
    }

    public ValidatableResponse getEpisode(int id) {
        return given()
                .when()
                .get(EPISODE_URN + "/" + id)
                .then();
    }
}
