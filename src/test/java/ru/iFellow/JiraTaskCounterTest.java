package ru.iFellow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JiraTaskCounterTest extends WebHooks {

    @Test
    @DisplayName("Переключение на проект \"Test\"")
    public void goToProjectTest() {
        authPage.authorize(conf.getUserName(), conf.getPassword())
                .checkAuthorize(conf.getUserName())
                .goToProject(conf.getTestProjectName())
                .checkProjectName(conf.getTestProjectName());
    }

    @Test
    @DisplayName("Проверка счетчика задач")
    public void counterTest() {
        authPage.authorize(conf.getUserName(), conf.getPassword())
                .checkAuthorize(conf.getUserName())
                .goToProject(conf.getTestProjectName())
                .checkProjectName(conf.getTestProjectName())
                .createIssue(conf.getCounterTaskName())
                .checkCounter();
    }
}
