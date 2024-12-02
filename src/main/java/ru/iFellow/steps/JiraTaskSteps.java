package ru.iFellow.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.pages.JiraTaskPage;

public class JiraTaskSteps {
    private final JiraTaskPage taskPage = new JiraTaskPage();

    @Дано("^перейти в задачу TestSeleniumATHomework")
    public void taskTest() {
        taskPage.goToTask();
    }

    @Тогда("^проверить детали задачи")
    public void checkDetails() {
        Assertions.assertEquals("Сделать", taskPage.getStatus());
        Assertions.assertEquals("Version 2.0", taskPage.getVersion());
    }

    @Дано("^создать отчет об ошибке")
    public void createNewReport() {
        taskPage.createBugReport();
//        Assertions.assertEquals("В работе", taskPage.getStatus());
//        taskPage.;
//        Assertions.assertEquals("Готово", taskPage.getStatus());
    }

    @Дано("^взять ошибку в работу")
    public void takeInWork() {
        taskPage.setInWorkStatus();
    }

    @Дано("^закрыть задачу")
    public void execIssue() {
        taskPage.setCompleteStatus();
    }

    @Тогда("^проверить статус (.*)")
    public void checkStatus(String status) {
        Assertions.assertEquals(status, taskPage.getStatus());
    }

}
