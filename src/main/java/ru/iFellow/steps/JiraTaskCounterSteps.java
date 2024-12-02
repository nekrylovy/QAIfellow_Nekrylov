package ru.iFellow.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.pages.JiraDashboardPage;
import ru.iFellow.pages.JiraProjectPage;

public class JiraTaskCounterSteps{
    private final JiraDashboardPage dashBoardPage = new JiraDashboardPage();
    private final JiraProjectPage projectPage = new JiraProjectPage();
    private int before;

    @Тогда("^перейти в проект Test")
    public void goToProjectTest() {
        dashBoardPage.goToProject();
    }

    @И("^проверить название проекта")
    public void checkProjectName() {
        Assertions.assertEquals("Test", projectPage.getProjectTitle());
    }

    @Тогда("^создать новую задачу")
    public void createNewTask() {
        before = projectPage.getIssueCounter();
        projectPage.createIssue();
        before++;
    }

    @И("^проверить счетчик задач")
    public void checkCounter() {
        int after = projectPage.getIssueCounter();
        Assertions.assertEquals(before, after);
    }
}
