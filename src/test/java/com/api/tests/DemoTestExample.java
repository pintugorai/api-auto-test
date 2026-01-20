package com.api.tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static org.hamcrest.number.OrderingComparison.lessThan;

public class DemoTestExample {
    @Test
    public void demoTest1(){
        ValidatableResponse res = RestAssured.given()
                .baseUri("https://api.restful-api.dev")
                .header("Content-type","application/json")
                .body("")
                .when()
                .log().all()
                .get("/objects")
                .then()
                .log().all()
                .statusCode(200)
                .time(lessThan(3000L));

        System.out.println("VR = " + res.extract().asPrettyString());
    }

    @Test
    public void demoTest2(){
        ValidatableResponse res = RestAssured.given()
                .baseUri("https://api.restful-api.dev")
                .contentType(ContentType.JSON)
                .body("")
                .when()
                .log().all()
                .get("/objects")
                .then()
                .log().all()
                .statusCode(200)
                .time(lessThan(3000L));

        System.out.println("VR = " + res.extract().asPrettyString());
    }

}
