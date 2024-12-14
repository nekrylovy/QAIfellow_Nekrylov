package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class JiraDashboardPage {
    private final SelenideElement userName = $x("//a[contains(@id, 'user-fullname')]").as("Имя текущего пользователя");
    private final SelenideElement projectsLink = $x("//a[text()='Проекты']/..").as("Пункт меню \"Проекты\"");
    private final SelenideElement projectsDropdownMenu = $x("//div[@id='browse_link-content']").as("Выпадающее меню проектов");

    public String getUserName() {
        return userName.getAttribute("data-username");
    }

    public JiraDashboardPage checkAuthorize(String userName) {
        Assertions.assertEquals(userName, this.getUserName());
        return Selenide.page(JiraDashboardPage.class);
    }

    public JiraProjectPage goToProject() {
        projectsLink.click();
        projectsDropdownMenu.shouldBe(Condition.visible)
                            .$x(".//a[contains(text(), 'Test')]")
                            .click();
        return Selenide.page(JiraProjectPage.class);
    }
}
