package ru.iFellow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.JiraAuthorizationPage;
import ru.iFellow.pages.JiraDashboardPage;
import ru.iFellow.pages.JiraProjectPage;

public class JiraTaskCounterTest extends WebHooks {
    private final JiraAuthorizationPage authPage = new JiraAuthorizationPage();
    private JiraDashboardPage dashBoardPage = new JiraDashboardPage();
    private final JiraProjectPage projectPage = new JiraProjectPage();
    private final String userName = "AT7";
    private final String password = "Qwerty123";

    @Test
    public void goToProjectTest() {
        dashBoardPage = authPage.authorize(userName, password);
        Assertions.assertEquals(userName, dashBoardPage.getUserName());

        dashBoardPage.goToProject();
        Assertions.assertEquals("Test", projectPage.getProjectTitle());
    }

    @Test
    public void counterTest() {
        dashBoardPage = authPage.authorize(userName, password);
        Assertions.assertEquals(userName, dashBoardPage.getUserName());

        dashBoardPage.goToProject();
        Assertions.assertEquals("Test", projectPage.getProjectTitle());

        int before = projectPage.getIssueCounter();
        projectPage.createIssue();
        before++;
        int after = projectPage.getIssueCounter();
        Assertions.assertEquals(before, after);
    }
}
