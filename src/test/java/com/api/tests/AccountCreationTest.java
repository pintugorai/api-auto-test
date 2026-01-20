package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {
    @Test()
    public void createAccountTest(){
        SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("User1").firstName("Pintu").lastName("Gorai").mobileNumber("1234567890").build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
    }
}
