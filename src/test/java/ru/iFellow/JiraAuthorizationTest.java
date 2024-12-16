package ru.iFellow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JiraAuthorizationTest extends WebHooks {

    @Test
    @DisplayName("Авторизация в \"edujira.ifellow.ru\"")
    public void logInJira() {
        authPage.authorize(userName, password)
                .checkAuthorize(userName);
    }

}
