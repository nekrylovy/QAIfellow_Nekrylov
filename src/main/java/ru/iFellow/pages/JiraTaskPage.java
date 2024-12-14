package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class JiraTaskPage {
    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']").as("Поле поиска");
    private final SelenideElement status = $x("//strong[text()='Статус:']/following-sibling::span[@id='status-val']/span").as("Статус задачи");
    private final SelenideElement version = $x("//strong[@title='Исправить в версиях']/following-sibling::span[@id='fixfor-val']//a").as("Исправить в версиях");
    private final SelenideElement createButton = $x("//a[text()='Создать']").as("Кнопка \"Создать\" в меню");
    private final SelenideElement themeInput = $x("//input[@id='summary']").as("Тема задачи");
    private final SelenideElement descriptionArea = $x("//textarea[@id='description']").as("Описание задачи");
    private final SelenideElement labelsArea = $x("//textarea[@id='labels-textarea']").as("Метки задачи");
    private final SelenideElement environmentArea = $x("//textarea[@id='environment']").as("Поле \"Окружение\"");
    private final SelenideElement taskLink = $x("//textarea[@id='issuelinks-issues-textarea']").as("Поле \"Связанные задачи\"");
    private final SelenideElement assignToMeButton = $x("//button[@id='assign-to-me-trigger']").as("Кнопка \"Назначить на меня\"");
    private final SelenideElement createIssueButton = $x("//input[@id='create-issue-submit']").as("Кнопка \"Создать\"");
    private final SelenideElement issueLink = $x("//a[@class='issue-created-key issue-link']").as("Ссылка на созданную задачу");
    private final SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']").as("Выпадающее меню \"Бизнес-процесс\"");
    private final SelenideElement inProcessButton = $x("//span[@class='trigger-label' and text()='В процессе']").as("Пункт меню \"В процессе\"");
    private final SelenideElement submitButton = $x("//input[@id='issue-workflow-transition-submit']").as("Кнопка подтверждения изменения статуса");
    private final SelenideElement successMsgExit = $x("//button[@class='aui-close-button']").as("Кнопка закрытия всплывающего уведомления");
    private final SelenideElement completeStatus = $x("//span[text()='Выполнено']").as("Пункт меню \"Выполнено\"");

    public JiraTaskPage goToTask() {
        searchInput.sendKeys("TestSeleniumATHomework");
        searchInput.pressEnter();
        return this;
    }

    public JiraTaskPage checkDetails() {
        Assertions.assertEquals("Сделать", this.getStatus());
        Assertions.assertEquals("Version 2.0", this.getVersion());
        return this;
    }

    public JiraTaskPage createBugReport() {
        createButton.click();
        themeInput.shouldBe(Condition.visible).sendKeys("Баг репорт");
        descriptionArea.sendKeys("Описание\nФактический результат:\nОжидаемый результат:");
        labelsArea.scrollIntoView(false);
        labelsArea.sendKeys("testBugReport");
        labelsArea.pressEnter();
        environmentArea.scrollIntoView(false);
        environmentArea.sendKeys("Windows 10 x64\nGoogle Chrome v. 131.0.6778.86");
        taskLink.scrollIntoView(false);
        taskLink.sendKeys("TEST-121544");
        assignToMeButton.scrollIntoView(false).click();
        createIssueButton.shouldBe(Condition.visible).click();
        issueLink.click();
        return this;
    }

    public JiraTaskPage setInWorkStatus() {
        businessProcess.shouldBe(Condition.visible).click();
        inProcessButton.shouldBe(Condition.visible).click();
        submitButton.shouldBe(Condition.visible).click();
        successMsgExit.click();
        Selenide.refresh();
        status.shouldBe(Condition.text("В работе"));
        return this;
    }

    public JiraTaskPage setCompleteStatus() {
        businessProcess.shouldBe(Condition.visible).click();
        completeStatus.shouldBe(Condition.visible).click();
        successMsgExit.click();
        Selenide.refresh();
        return this;
    }

    public JiraTaskPage checkStatus(String status) {
        Assertions.assertEquals(status, this.getStatus());
        return this;
    }

    public String getStatus() {
        return status.getOwnText();
    }

    public String getVersion() {
        return version.getOwnText();
    }

}
