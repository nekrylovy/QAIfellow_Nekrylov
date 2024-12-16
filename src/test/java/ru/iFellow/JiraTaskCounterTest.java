package ru.iFellow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JiraTaskCounterTest extends WebHooks {

    @Test
    @DisplayName("Переключение на проект \"Test\"")
    public void goToProjectTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject(prop.getProperty("testProjectName"))
                .checkProjectName(prop.getProperty("testProjectName"));
    }

    @Test
    @DisplayName("Проверка счетчика задач")
    public void counterTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject(prop.getProperty("testProjectName"))
                .checkProjectName(prop.getProperty("testProjectName"))
                .createIssue("Задача для теста счетчика")
                .checkCounter();
    }

}
