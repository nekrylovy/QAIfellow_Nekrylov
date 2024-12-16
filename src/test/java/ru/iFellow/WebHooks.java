package ru.iFellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import ru.iFellow.pages.JiraAuthorizationPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    static final JiraAuthorizationPage authPage = new JiraAuthorizationPage();
    Properties prop = new Properties();
    String userName;
    String password;

    {
        try (InputStream input = new FileInputStream("src/test/resources/jiraTests.properties")) {
            prop.load(input);
            userName = prop.getProperty("login");
            password = prop.getProperty("password");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Selenide.open(prop.getProperty("url"));
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
