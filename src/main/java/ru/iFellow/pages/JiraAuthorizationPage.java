package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraAuthorizationPage {
    private final SelenideElement userNameInput = $x("//input[@id='login-form-username']");
    private final SelenideElement passwordInput = $x("//input[@id='login-form-password']");
    private final SelenideElement logInButton = $x("//input[@id='login']");

    public JiraDashboardPage authorize(String userName, String password) {
        userNameInput.shouldBe(Condition.visible).sendKeys(userName);
        passwordInput.sendKeys(password);
        logInButton.click();
        return Selenide.page(JiraDashboardPage.class);
    }
}