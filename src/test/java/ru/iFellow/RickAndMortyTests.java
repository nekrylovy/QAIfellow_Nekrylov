package ru.iFellow;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.iFellow.steps.RickAndMortySteps;

import java.util.Objects;

public class RickAndMortyTests {
    private static final RickAndMortySteps steps = new RickAndMortySteps();

    Logger logger = LoggerFactory.getLogger(RickAndMortyTests.class);

    @Test
    public void rickAndMortyTest() {
        JsonPath mortyPath = findMortyInfo();
        int lastEpisodeId = getLastMortyEpisode(mortyPath);
        int lastCharacterId = getLastCharacter(lastEpisodeId);
        compareCharactersInfo(mortyPath, lastCharacterId);
    }

    public JsonPath findMortyInfo() {
        JsonPath charactersPath = steps.getCharacterPath();
        JsonPath mortyPath = charactersPath.setRootPath("results.find{it.name == 'Morty Smith'}");
        logger.info(mortyPath.getString("name"));
        Assertions.assertEquals("Morty Smith", mortyPath.getString("name"));
        return mortyPath;
    }

    public int getLastMortyEpisode(JsonPath mortyPath) {
        String lastEpisode = mortyPath.getString("episode[-1]");
        int lastEpisodeId = getId(lastEpisode);
        logger.info("\n\tLast episode: {}\n\tid: {}", lastEpisode, lastEpisodeId);
        Assertions.assertTrue(lastEpisode.endsWith(String.valueOf(lastEpisodeId)));
        return lastEpisodeId;
    }

    public int getLastCharacter(int episodeId) {
        JsonPath episodePath = steps.getEpisodePath(episodeId);
        String lastCharacter = episodePath.getString("characters[-1]");
        int lastCharacterId = getId(lastCharacter);
        logger.info("\n\tLast character: {}\n\tid: {}", lastCharacter, lastCharacterId);
        Assertions.assertTrue(lastCharacter.endsWith(String.valueOf(lastCharacterId)));
        return lastCharacterId;
    }

    public void compareCharactersInfo(JsonPath mortyPath, int characterId) {
        JsonPath characterPath = steps.getCharacterPath(characterId);
        String species = characterPath.getString("species");
        String location = characterPath.getString("location.name");
        String mortySpecies = mortyPath.getString("species");
        String mortyLocation = mortyPath.getString("location.name");

        logger.info("""
                     Name: {}
                        Species: {}
                        Location: {}""", mortyPath.getString("name"), mortySpecies, mortyLocation);
        logger.info("""
                    Name: {}
                        Species: {}
                        Location: {}""", characterPath.getString("name"), species, location);
        logger.info("""
                    
                    Species: {}
                    Location: {}
                    """, (Objects.equals(mortySpecies, species)), (Objects.equals(mortyLocation, location)));
    }

    private int getId(String url) {
        String[] tokens = url.split("/");
        return Integer.parseInt(tokens[tokens.length - 1]);
    }

}
