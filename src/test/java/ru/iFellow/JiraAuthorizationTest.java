package ru.iFellow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.JiraAuthorizationPage;
import ru.iFellow.pages.JiraDashboardPage;

public class JiraAuthorizationTest extends WebHooks {
    private final JiraAuthorizationPage authPage = new JiraAuthorizationPage();

    @Test
    public void logInJira() {
        String userName = "AT7";
        String password = "Qwerty123";
        JiraDashboardPage dashBoardPage;
        dashBoardPage = authPage.authorize(userName, password);
        Assertions.assertEquals(userName, dashBoardPage.getUserName());
    }
}
