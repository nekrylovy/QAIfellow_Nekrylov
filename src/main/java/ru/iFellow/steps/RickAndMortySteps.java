package ru.iFellow.steps;

import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.api.RickAndMortyApi;

public class RickAndMortySteps {
    private static final RickAndMortyApi api = new RickAndMortyApi();
    private JsonPath currentPath;
    private JsonPath morty;

    @Если("^найти информацию по персонажу (\\w* \\w*)")
    public RickAndMortySteps findMorty(String name) {
        currentPath = getCharactersPath().setRootPath("results.find{it.name == '" + name + "'}");
        return this;
    }

    @Тогда("^проверить имя (\\w* \\w*)")
    public RickAndMortySteps checkMortyName(String name) {
        Assertions.assertEquals(name, currentPath.getString("name"));
        morty = currentPath;
        return this;
    }

    @И("^получить последний эпизод")
    public RickAndMortySteps getLastEpisode() {
        currentPath = getJsonPath(currentPath.getString("episode[-1]"));
        return this;
    }

    @Тогда("^получить последнего персонажа")
    public RickAndMortySteps getLastCharacter() {
        currentPath = getJsonPath(currentPath.getString("characters[-1]"));
        return this;
    }

    @И("^сравнить вид и местоположение этого персонажа с Morty")
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
