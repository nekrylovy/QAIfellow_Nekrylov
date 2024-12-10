package ru.iFellow;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.iFellow.steps.UserSteps;

public class UserTests {
    private static final UserSteps steps = new UserSteps();

    @Test
    public void newUserTest() {
        JsonPath response = steps.createNewUser();
        Assertions.assertEquals("Tomato", response.getString("name"));
        Assertions.assertEquals("Eat market", response.getString("Job"));
    }
}
