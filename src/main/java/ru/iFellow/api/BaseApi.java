package ru.iFellow.api;

import io.restassured.RestAssured;

public abstract class BaseApi {
    public BaseApi(String url) {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(url);
        RestAssured.responseSpecification = Specifications.baseResponseSpec();
    }
}
