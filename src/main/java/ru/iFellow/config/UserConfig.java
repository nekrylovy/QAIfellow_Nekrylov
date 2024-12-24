package ru.iFellow.config;

import lombok.Getter;

public class UserConfig extends Config {
    private @Getter String URL;
    private @Getter String USERS_URN;

    public UserConfig() {
        super("src/test/resources/User.properties");
        URL = prop.getProperty("URL");
        USERS_URN = prop.getProperty("USERS_URN");
    }
}
