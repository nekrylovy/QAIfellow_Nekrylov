package ru.iFellow.config;

import lombok.Getter;

public class RickAndMortyConfig extends Config {
    private @Getter String URL;
    private @Getter String CHARACTERS_URN;

    public RickAndMortyConfig() {
        super("src/test/resources/RickAndMorty.properties");
        URL = prop.getProperty("URL");
        CHARACTERS_URN = prop.getProperty("CHARACTERS_URN");
    }
}
