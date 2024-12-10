package ru.iFellow.steps;

import io.restassured.path.json.JsonPath;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ru.iFellow.api.UserApi;
import java.io.FileReader;


public class UserSteps {
    private static final UserApi api = new UserApi();
    private static final String filePath = "src/test/resources/user.json";

    @SneakyThrows
    public JsonPath createNewUser() {
        Object object = new JSONParser().parse(new FileReader(filePath));
        JSONObject user = (JSONObject) object;
        user.replace("name", "Tomato");
        user.put("Job", "Eat market");

        return api.postUser(user.toString())
                .extract()
                .body()
                .jsonPath();
    }
}
