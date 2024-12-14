package ru.iFellow;

import org.junit.jupiter.api.Test;
import ru.iFellow.pages.JiraAuthorizationPage;

public class JiraAuthorizationTest extends WebHooks {
    private final JiraAuthorizationPage authPage = new JiraAuthorizationPage();

    @Test
    public void logInJira() {
        // TODO: properties
        String userName = "AT7";
        String password = "Qwerty123";
        authPage.authorize(userName, password)
                .checkAuthorize(userName);
    }
}
