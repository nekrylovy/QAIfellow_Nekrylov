package ru.iFellow;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.JiraAuthorizationPage;
import ru.iFellow.pages.JiraDashboardPage;
import ru.iFellow.pages.JiraProjectPage;
import ru.iFellow.pages.JiraTaskPage;

public class JiraTaskTest extends WebHooks {
    private final JiraAuthorizationPage authPage = new JiraAuthorizationPage();
    private JiraDashboardPage dashBoardPage = new JiraDashboardPage();
    private final JiraProjectPage projectPage = new JiraProjectPage();
    private final JiraTaskPage taskPage = new JiraTaskPage();
    private final String userName = "AT7";
    private final String password = "Qwerty123";

    @Test
    public void taskTest() {
        dashBoardPage = authPage.authorize(userName, password);
        Assertions.assertEquals(userName, dashBoardPage.getUserName());

        dashBoardPage.goToProject();
        Assertions.assertEquals("Test", projectPage.getProjectTitle());

        int before = projectPage.getIssueCounter();
        projectPage.createIssue();
        before++;
        int after = projectPage.getIssueCounter();
        Assertions.assertEquals(before, after);

        taskPage.goToTask();
        Assertions.assertEquals("Сделать", taskPage.getStatus());
        Assertions.assertEquals("Version 2.0", taskPage.getVersion());
    }

    @Test
    public void bugTest() {
        dashBoardPage = authPage.authorize(userName, password);
        Assertions.assertEquals(userName, dashBoardPage.getUserName());

        dashBoardPage.goToProject();
        Assertions.assertEquals("Test", projectPage.getProjectTitle());

        int before = projectPage.getIssueCounter();
        projectPage.createIssue();
        before++;
        int after = projectPage.getIssueCounter();
        Assertions.assertEquals(before, after);

        taskPage.goToTask();
        Assertions.assertEquals("Сделать", taskPage.getStatus());
        Assertions.assertEquals("Version 2.0", taskPage.getVersion());

        taskPage.createBugReport();
        taskPage.setInWorkStatus();
        Assertions.assertEquals("В работе", taskPage.getStatus());
        taskPage.setCompleteStatus();
        Assertions.assertEquals("Готово", taskPage.getStatus());
    }
}
