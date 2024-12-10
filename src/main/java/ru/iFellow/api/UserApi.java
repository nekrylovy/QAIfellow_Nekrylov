package ru.iFellow.api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserApi extends BaseApi {

    private static final String USERS_URN = "/users";

    public UserApi() {
        super("https://reqres.in/api");
    }

    public ValidatableResponse postUser(String user) {
        return given()
                .when().body(user)
                .post(USERS_URN)
                .then()
                .statusCode(201);
    }
}
