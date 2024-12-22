package ru.iFellow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JiraTaskTest extends WebHooks {

    @Test
    @DisplayName("Проверка деталей задачи \"TestSeleniumATHomework\"")
    public void taskDetailsTest() {
        authPage.authorize(conf.getUserName(), conf.getPassword())
                .checkAuthorize(conf.getUserName())
                .goToProject(conf.getTestProjectName())
                .checkProjectName(conf.getTestProjectName())
                .createIssue(conf.getCounterTaskName())
                .checkCounter()
                .goToTask(conf.getDetailsTaskName())
                .checkDetails("Сделать", "Version 2.0");
    }

    @Test
    @DisplayName("Заведение бага и перевод задачи по статусам")
    public void bugTest() {
        authPage.authorize(conf.getUserName(), conf.getPassword())
                .checkAuthorize(conf.getUserName())
                .goToProject(conf.getTestProjectName())
                .checkProjectName(conf.getTestProjectName())
                .createIssue(conf.getCounterTaskName())
                .checkCounter()
                .goToTask(conf.getDetailsTaskName())
                .checkDetails("Сделать", "Version 2.0")
                .createBugReport(conf.getIssueReportName())
                .checkStatus("Сделать")
                .setInWorkStatus()
                .checkStatus("В работе")
                .setCompleteStatus()
                .checkStatus("Готово");
    }
}
