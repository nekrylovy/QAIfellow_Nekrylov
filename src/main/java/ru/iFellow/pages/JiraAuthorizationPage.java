package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraAuthorizationPage {
    private final SelenideElement userNameInput = $x("//input[@id='login-form-username']");
    private final SelenideElement passwordInput = $x("//input[@id='login-form-password']");
    private final SelenideElement logInButton = $x("//input[@id='login']");

    public void fillUserNameInput(String userName) {
        userNameInput.shouldBe(Condition.visible).sendKeys(userName);
    }
    public void fillPasswordInput(String userName) {
        passwordInput.shouldBe(Condition.visible).sendKeys(userName);
    }
    public JiraDashboardPage authorize() {
        logInButton.click();
        return Selenide.page(JiraDashboardPage.class);
    }
}
