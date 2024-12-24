package ru.iFellow;

import org.junit.jupiter.api.Test;
import ru.iFellow.steps.UserSteps;

public class UserTest {
    private static final UserSteps steps = new UserSteps();

    @Test
    public void newUserTest() {
        steps.createNewUser()
             .checkData();
    }
}
