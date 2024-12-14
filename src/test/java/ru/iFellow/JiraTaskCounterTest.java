package ru.iFellow;

import org.junit.jupiter.api.Test;
import ru.iFellow.pages.JiraAuthorizationPage;

public class JiraTaskCounterTest extends WebHooks {
    private final JiraAuthorizationPage authPage = new JiraAuthorizationPage();
    private final String userName = "AT7";
    private final String password = "Qwerty123";

    @Test
    public void goToProjectTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject()
                .checkProjectName();
    }

    @Test
    public void counterTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject()
                .checkProjectName()
                .createIssue()
                .checkCounter();
    }
}
