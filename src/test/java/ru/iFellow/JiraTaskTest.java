package ru.iFellow;

import org.junit.jupiter.api.Test;
import ru.iFellow.pages.JiraAuthorizationPage;

public class JiraTaskTest extends WebHooks {
    private final JiraAuthorizationPage authPage = new JiraAuthorizationPage();
    private final String userName = "AT7";
    private final String password = "Qwerty123";

    @Test
    public void taskTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject()
                .checkProjectName()
                .createIssue()
                .checkCounter()
                .goToTask()
                .checkDetails();
    }

    @Test
    public void bugTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject()
                .checkProjectName()
                .createIssue()
                .checkCounter()
                .goToTask()
                .checkDetails()
                .createBugReport()
                .setInWorkStatus()
                .checkStatus("В работе")
                .setCompleteStatus()
                .checkStatus("Готово");
    }
}
