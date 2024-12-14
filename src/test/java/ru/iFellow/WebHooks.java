package ru.iFellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    Properties properties = new Properties();
    String userName;
    String password;

    {
        try (InputStream input = new FileInputStream("src/test/resources/authorization.properties")) {
            properties.load(input);
            userName = properties.getProperty("login");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Selenide.open(properties.getProperty("url"));
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
