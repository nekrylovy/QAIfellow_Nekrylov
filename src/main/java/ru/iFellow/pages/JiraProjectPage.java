package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraProjectPage {
    private final SelenideElement projectTitle = $x("//div[@class='aui-item project-title']/child::a");
    private final SelenideElement issueCounter = $x("//div[@class='showing']/child::span");
    private final SelenideElement createButton = $x("//a[text()='Создать']");
    private final SelenideElement themeInput = $x("//input[@id='summary']");
    private final SelenideElement createIssueButton = $x("//input[@id='create-issue-submit']");
    private final SelenideElement successMsgExit = $x("//button[@class='aui-close-button']");

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
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return result;
    }

    public void createIssue() {
        createButton.click();
        themeInput.shouldBe(Condition.visible).sendKeys("Задача для теста счетчика");
        createIssueButton.shouldBe(Condition.visible).click();
        successMsgExit.click();
        Selenide.refresh();
    }
}
