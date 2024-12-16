package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class JiraAuthorizationPage {
    private final SelenideElement userNameInput = $x("//input[@id='login-form-username']").as("Поле \"Имя пользователя\"");
    private final SelenideElement passwordInput = $x("//input[@id='login-form-password']").as("Поле \"Пароль\"");
    private final SelenideElement logInButton = $x("//input[@id='login']").as("Кнопка \"Войти\"");

    @Step("Авторизация пользователя \"{userName}\" с паролем \"{password}\"")
    public JiraDashboardPage authorize(String userName, String password) {
        userNameInput.shouldBe(Condition.visible).sendKeys(userName);
        passwordInput.sendKeys(password);
        logInButton.click();
        return Selenide.page(JiraDashboardPage.class);
    }
}
