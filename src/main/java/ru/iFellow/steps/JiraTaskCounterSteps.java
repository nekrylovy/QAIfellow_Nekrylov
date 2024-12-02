package ru.iFellow.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.pages.JiraDashboardPage;
import ru.iFellow.pages.JiraProjectPage;

public class JiraTaskCounterSteps{
    private final JiraDashboardPage dashBoardPage = new JiraDashboardPage();
    private final JiraProjectPage projectPage = new JiraProjectPage();
    private int before;

    @Дано("^перейти в проект Test")
    public void goToProjectTest() {
        dashBoardPage.goToProject();
    }

    @Тогда("^проверить название проекта")
    public void checkProjectName() {
        Assertions.assertEquals("Test", projectPage.getProjectTitle());
    }

    @Дано("^создать новую задачу")
    public void createNewTask() {
        before = projectPage.getIssueCounter();
        projectPage.createIssue();
        before++;
    }

    @Тогда("^проверить счетчик задач")
    public void checkCounter() {
        int after = projectPage.getIssueCounter();
        Assertions.assertEquals(before, after);
    }
}
