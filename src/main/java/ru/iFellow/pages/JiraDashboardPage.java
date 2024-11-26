package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraDashboardPage {
    private final SelenideElement userName = $x("//a[contains(@id, 'user-fullname')]");
    private final SelenideElement projectsLink = $x("//a[text()='Проекты']/..");
    private final SelenideElement projectsDropdownMenu = $x("//div[@id='browse_link-content']");

    public String getUserName() {
        return userName.getAttribute("data-username");
    }

    public void goToProject() {
        projectsLink.click();
        projectsDropdownMenu.shouldBe(Condition.visible)
                            .$x(".//a[contains(text(), 'Test')]")
                            .click();
    }
}
