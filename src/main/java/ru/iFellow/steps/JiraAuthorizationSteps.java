package ru.iFellow.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.pages.JiraAuthorizationPage;
import ru.iFellow.pages.JiraDashboardPage;

public class JiraAuthorizationSteps {
    private String userName;
    private String password;
    private final JiraAuthorizationPage authPage = new JiraAuthorizationPage();
    private JiraDashboardPage dashBoardPage;

    @Когда("^введен логин (.*)")
    public void enterUserName(String userName) {
        this.userName = userName;
        authPage.fillUserNameInput(userName);
    }

    @И("^введен пароль (.*)")
    public void enterPassword(String password) {
        authPage.fillPasswordInput(password);
    }

    @Тогда("^нажать кнопку Войти")
    public void logInJira() {
        dashBoardPage = authPage.authorize();
    }

    @И("^проверить имя пользователя в профиле")
    public void checkLogIn() {
        Assertions.assertEquals(userName, dashBoardPage.getUserName());
    }
}
