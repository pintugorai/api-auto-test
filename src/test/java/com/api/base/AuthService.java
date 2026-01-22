package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends BaseService{
    private static final String BASE_PATH="/api/auth/";

    public Response login(LoginRequest payload){
        return postRequest(payload,BASE_PATH+"login");
    }

    public Response signUp(SignUpRequest payload){
        return postRequest(payload,BASE_PATH+"signup");
    }

    /* If the input json has single key-value pair. No need to create pojo class, user hash map and use as payload.
    As below -
    {
        email:"Abc@gmail.com"
     }
    * */
    public Response forgotPassword(String emailAddress){
        HashMap<String, String> payload = new HashMap<>();
        payload.put("email",emailAddress);
        return postRequest(payload,BASE_PATH+"forgot-password");
    }

}
