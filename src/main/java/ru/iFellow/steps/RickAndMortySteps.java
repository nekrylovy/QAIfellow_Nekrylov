package ru.iFellow.steps;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.api.RickAndMortyApi;

public class RickAndMortySteps {
    private static final RickAndMortyApi api = new RickAndMortyApi();
    private JsonPath currentPath;
    private JsonPath morty;

    public RickAndMortySteps findMorty() {
        currentPath = getCharactersPath().setRootPath("results.find{it.name == 'Morty Smith'}");
        return this;
    }

    public RickAndMortySteps checkMortyName() {
        Assertions.assertEquals("Morty Smith", currentPath.getString("name"));
        morty = currentPath;
        return this;
    }

    public RickAndMortySteps getLastEpisode() {
        currentPath = getJsonPath(currentPath.getString("episode[-1]"));
        return this;
    }

    public RickAndMortySteps getLastCharacter() {
        currentPath = getJsonPath(currentPath.getString("characters[-1]"));
        return this;
    }

    public RickAndMortySteps compareCharactersInfo() {
        Assertions.assertEquals(morty.getString("species"), currentPath.getString("species"));
        Assertions.assertNotEquals(morty.getString("location.name"), currentPath.getString("location.name"));
        return this;
    }

    public JsonPath getCharactersPath() {
        return api.getCharacters()
                  .statusCode(HttpStatus.SC_OK)
                  .extract()
                  .body()
                  .jsonPath();
    }

    public JsonPath getJsonPath(String url) {
        return api.get(url)
                  .statusCode(HttpStatus.SC_OK)
                  .extract()
                  .body()
                  .jsonPath();
    }

}
