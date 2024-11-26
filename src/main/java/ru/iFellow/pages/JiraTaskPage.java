package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraTaskPage {
    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']");
    private final SelenideElement status = $x("//strong[text()='Статус:']/following-sibling::span[@id='status-val']/span");
    private final SelenideElement version = $x("//strong[@title='Исправить в версиях']/following-sibling::span[@id='fixfor-val']//a");
    private final SelenideElement createButton = $x("//a[text()='Создать']");
    private final SelenideElement themeInput = $x("//input[@id='summary']");
    private final SelenideElement descriptionArea = $x("//textarea[@id='description']");
    private final SelenideElement labelsArea = $x("//textarea[@id='labels-textarea']");
    private final SelenideElement environmentArea = $x("//textarea[@id='environment']");
    private final SelenideElement taskLink = $x("//textarea[@id='issuelinks-issues-textarea']");
    private final SelenideElement assignToMeButton = $x("//button[@id='assign-to-me-trigger']");
    private final SelenideElement createIssueButton = $x("//input[@id='create-issue-submit']");
    private final SelenideElement issueLink = $x("//a[@class='issue-created-key issue-link']");
    private final SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']");
    private final SelenideElement inProcessButton = $x("//span[@class='trigger-label' and text()='В процессе']");
    private final SelenideElement submitButton = $x("//input[@id='issue-workflow-transition-submit']");
    private final SelenideElement successMsgExit = $x("//button[@class='aui-close-button']");
    private final SelenideElement completeStatus = $x("//span[text()='Выполнено']");

    public void goToTask() {
        searchInput.sendKeys("TestSeleniumATHomework");
        searchInput.pressEnter();
    }

    public String getStatus() {
        return status.getOwnText();
    }

    public String getVersion() {
        return version.getOwnText();
    }

    public void createBugReport() {
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
    }

    public void setInWorkStatus() {
        businessProcess.shouldBe(Condition.visible).click();
        inProcessButton.shouldBe(Condition.visible).click();
        submitButton.shouldBe(Condition.visible).click();
        successMsgExit.click();
        Selenide.refresh();
        status.shouldBe(Condition.text("В работе"));
    }

    public void setCompleteStatus() {
        businessProcess.shouldBe(Condition.visible).click();
        completeStatus.shouldBe(Condition.visible).click();
        successMsgExit.click();
        Selenide.refresh();
    }

}
