package ru.iFellow.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.pages.JiraTaskPage;

public class JiraTaskSteps {
    private final JiraTaskPage taskPage = new JiraTaskPage();

    @Тогда("^перейти в задачу TestSeleniumATHomework")
    public void taskTest() {
        taskPage.goToTask();
    }

    @И("^проверить детали задачи")
    public void checkDetails() {
        Assertions.assertEquals("Сделать", taskPage.getStatus());
        Assertions.assertEquals("Version 2.0", taskPage.getVersion());
    }

    @Тогда("^создать отчет об ошибке")
    public void createNewReport() {
        taskPage.createBugReport();
    }

    @Тогда("^взять ошибку в работу")
    public void takeInWork() {
        taskPage.setInWorkStatus();
    }

    @Тогда("^закрыть задачу")
    public void execIssue() {
        taskPage.setCompleteStatus();
    }

    @И("^проверить статус (.*)")
    public void checkStatus(String status) {
        Assertions.assertEquals(status, taskPage.getStatus());
    }

}
