package ru.iFellow.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Hooks {

    @Before("@jira")
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Selenide.open("https://edujira.ifellow.ru/");
        getWebDriver().manage().window().maximize();
    }

    @After("@jira")
    public void killBrowser() {
        Selenide.closeWebDriver();
    }
}
