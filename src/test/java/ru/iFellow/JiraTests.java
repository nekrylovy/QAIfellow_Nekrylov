package ru.iFellow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.JiraAuthorizationPage;

public class JiraTests extends WebHooks {
    private final JiraAuthorizationPage authPage = new JiraAuthorizationPage();

    @Test
    @DisplayName("Авторизация в \"edujira.ifellow.ru\"")
    public void logInJira() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName);
    }

    @Test
    @DisplayName("Переключение на проект \"Test\"")
    public void goToProjectTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject()
                .checkProjectName();
    }

    @Test
    @DisplayName("Проверка счетчика задач")
    public void counterTest() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName)
                .goToProject()
                .checkProjectName()
                .createIssue()
                .checkCounter();
    }

    @Test
    @DisplayName("Проверка деталей задачи \"TestSeleniumATHomework\"")
    public void taskDetailsTest() {
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
    @DisplayName("Заведение бага и перевод задачи по статусам")
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
                .checkStatus("Сделать")
                .setInWorkStatus()
                .checkStatus("В работе")
                .setCompleteStatus()
                .checkStatus("Готово");
    }
}
