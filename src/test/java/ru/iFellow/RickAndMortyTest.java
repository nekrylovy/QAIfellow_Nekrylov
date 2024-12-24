package ru.iFellow;

import org.junit.jupiter.api.Test;
import ru.iFellow.steps.RickAndMortySteps;

public class RickAndMortyTest {
    private static final RickAndMortySteps steps = new RickAndMortySteps();

    @Test
    public void rickAndMortyTest() {
        steps.findMorty()
             .checkMortyName()
             .getLastEpisode()
             .getLastCharacter()
             .compareCharactersInfo();
    }
}
