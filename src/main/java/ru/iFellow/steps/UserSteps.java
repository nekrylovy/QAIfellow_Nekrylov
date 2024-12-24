package ru.iFellow.steps;

import io.restassured.path.json.JsonPath;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.api.UserApi;
import java.io.FileReader;

public class UserSteps {
    private static final UserApi api = new UserApi();
    private static final String filePath = "src/test/resources/user.json";
    private JsonPath response;

    @SneakyThrows
    public UserSteps createNewUser() {
        Object object = new JSONParser().parse(new FileReader(filePath));
        JSONObject user = (JSONObject) object;
        user.replace("name", "Tomato");
        user.put("Job", "Eat market");

        response = api.postUser(user.toString())
                      .extract()
                      .body()
                      .jsonPath();
        return this;
    }

    public UserSteps checkData() {
        Assertions.assertEquals("Tomato", response.getString("name"));
        Assertions.assertEquals("Eat market", response.getString("Job"));
        return this;
    }
}
