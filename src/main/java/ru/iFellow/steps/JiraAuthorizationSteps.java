package ru.iFellow.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.pages.JiraAuthorizationPage;
import ru.iFellow.pages.JiraDashboardPage;

public class JiraAuthorizationSteps {
    private String userName;
    private final JiraAuthorizationPage authPage = new JiraAuthorizationPage();
    private JiraDashboardPage dashBoardPage;

    @Дано("^логин (.*) и пароль (.*)")
    public void logInJira(String userName, String password) {
        this.userName = userName;
        dashBoardPage = authPage.authorize(userName, password);
    }

    @Тогда("^проверить имя пользователя в профиле")
    public void checkLogIn() {
        Assertions.assertEquals(userName, dashBoardPage.getUserName());
    }
}
