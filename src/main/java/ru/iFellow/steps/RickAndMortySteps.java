package ru.iFellow.steps;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import ru.iFellow.api.RickAndMortyApi;

public class RickAndMortySteps {
    private static final RickAndMortyApi api = new RickAndMortyApi();

    public JsonPath getCharacterPath() {
        return api.getCharacter()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }

    public JsonPath getCharacterPath(int id) {
        return api.getCharacter(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }

    public JsonPath getEpisodePath(int id) {
        return api.getEpisode(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .jsonPath();
    }
}
