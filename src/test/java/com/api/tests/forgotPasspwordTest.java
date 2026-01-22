package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class forgotPasspwordTest {
    @Test()
    public void forgotPasswordtest(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("abc@gamil.com");
        System.out.println(response.asPrettyString());
    }
}
