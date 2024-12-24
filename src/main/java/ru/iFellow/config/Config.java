package ru.iFellow.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class Config {
    Properties prop = new Properties();

    public Config(String propertyPath) {
        try (InputStream input = new FileInputStream(propertyPath)) {
            prop.load(input);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
