package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class JiraProjectPage {
    private final SelenideElement projectTitle = $x("//div[@class='aui-item project-title']/child::a").as("Название проекта");
    private final SelenideElement issueCounter = $x("//div[@class='showing']/child::span").as("Счетчик задач");
    private final SelenideElement createButton = $x("//a[text()='Создать']").as("Поле поиска");
    private final SelenideElement themeInput = $x("//input[@id='summary']").as("Тема задачи");
    private final SelenideElement createIssueButton = $x("//input[@id='create-issue-submit']").as("Кнопка \"Создать\"");
    private final SelenideElement successMsgExit = $x("//button[@class='aui-close-button']").as("Кнопка закрытия всплывающего уведомления");
    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']").as("Поле поиска");
    private int beforeCounter;

    @Step("Проверка имени проекта \"{projectName}\"")
    public JiraProjectPage checkProjectName(String projectName) {
        Assertions.assertEquals(projectName, this.getProjectTitle());
        return this;
    }

    @Step("Создание задачи \"{taskName}\"")
    public JiraProjectPage createIssue(String taskName) {
        beforeCounter = getIssueCounter();
        createButton.click();
        themeInput.shouldBe(Condition.visible).sendKeys(taskName);
        createIssueButton.shouldBe(Condition.visible).click();
        successMsgExit.click();
        Selenide.refresh();
        beforeCounter++;
        return this;
    }

    @Step("Проверка счетчика задач")
    public JiraProjectPage checkCounter() {
        int afterCounter = getIssueCounter();
        Assertions.assertEquals(beforeCounter, afterCounter);
        return this;
    }

    @Step("Переключение на задачу \"{taskName}\"")
    public JiraTaskPage goToTask(String taskName) {
        searchInput.sendKeys(taskName);
        searchInput.pressEnter();
        return Selenide.page(JiraTaskPage.class);
    }

    public String getProjectTitle() {
        return projectTitle.getOwnText();
    }

    public int getIssueCounter() {
        String[] counter = issueCounter.shouldBe(Condition.visible).getOwnText().split(" ");
        int result = -1;
        try
        {
            result = Integer.parseInt(counter[2]);
        }
        catch (NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }
        return result;
    }

}
