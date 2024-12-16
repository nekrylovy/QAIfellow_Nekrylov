package ru.iFellow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JiraTaskTest extends WebHooks {

    @Test
    @DisplayName("Проверка деталей задачи \"TestSeleniumATHomework\"")
    public void taskDetailsTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject(prop.getProperty("testProjectName"))
                .checkProjectName(prop.getProperty("testProjectName"))
                .createIssue(prop.getProperty("counterTaskName"))
                .checkCounter()
                .goToTask(prop.getProperty("detailsTaskName"))
                .checkDetails("Сделать", "Version 2.0");
    }

    @Test
    @DisplayName("Заведение бага и перевод задачи по статусам")
    public void bugTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject(prop.getProperty("testProjectName"))
                .checkProjectName(prop.getProperty("testProjectName"))
                .createIssue(prop.getProperty("counterTaskName"))
                .checkCounter()
                .goToTask(prop.getProperty("detailsTaskName"))
                .checkDetails("Сделать", "Version 2.0")
                .createBugReport(prop.getProperty("issueReportName"))
                .checkStatus("Сделать")
                .setInWorkStatus()
                .checkStatus("В работе")
                .setCompleteStatus()
                .checkStatus("Готово");
    }
}
