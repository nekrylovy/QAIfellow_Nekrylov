package ru.iFellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import ru.iFellow.pages.JiraAuthorizationPage;
import ru.iFellow.config.Config;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    static final JiraAuthorizationPage authPage = new JiraAuthorizationPage();
    final Config conf = new Config();

    @BeforeAll
    public static void initLogger() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Selenide.open(conf.getUrl());
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
