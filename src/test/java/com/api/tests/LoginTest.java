package com.api.tests;

import com.api.base.AuthService;
import com.api.listeners.TestListener;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.LoginResponse1;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestListener.class})
public class LoginTest {
    private static final Logger logger = (Logger) LogManager.getLogger(LoginTest.class);

    //@Test()
    public void sampleRestassuredTest(){
        RestAssured.baseURI="https://localhost:8080";
        Response response = RestAssured.given().header("Content-Type","application/json").body("").post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);

        //OR
        Response response1 = RestAssured.given().baseUri("https://localhost:8080").header("Content-Type","application/json").body("").post("/api/auth/login");
    }

    @Test()
    public void loginTest(){
        AuthService authService = new AuthService();
        //Response response = authService.login("{\"username\": \"user1\",\"password\":\"password1\"}");
        //System.out.println("Response = " + response.asPrettyString());
        logger.info("test ");
    }

    @Test() // Serilized
    public void loginTestUseRequestModels(){
        LoginRequest loginRequest = new LoginRequest("user1", "password1");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        System.out.println("Response = " + response.asPrettyString());
    }

    @Test() // De-Serilized
    public void loginTestUseRequestAndResponseModels(){
        LoginRequest loginRequest = new LoginRequest("user1", "password1");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        // purpose of as() method it convert json object ot java object of your pojo class.
        LoginResponse1 loginResponse = response.as(LoginResponse1.class); // as() is a method that get the body and map it to java object. response json to java object of your class
        System.out.println("Status = " + loginResponse.getStatus());
    }
}
