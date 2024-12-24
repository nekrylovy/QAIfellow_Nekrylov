package ru.iFellow.api;

import io.restassured.response.ValidatableResponse;
import ru.iFellow.config.UserConfig;

import static io.restassured.RestAssured.given;

public class UserApi extends BaseApi {
    private static final UserConfig config = new UserConfig();

    public UserApi() {
        super(config.getURL());
    }

    public ValidatableResponse postUser(String user) {
        return given()
                .when().body(user)
                .post(config.getUSERS_URN())
                .then()
                .statusCode(201);
    }
}
