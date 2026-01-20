package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { //wrapper for Rest Assured!
    //Base URI
    // Creating the Request
    //Handline the response

    private static final String BASE_URL="https://api.restful-api.dev";
    private RequestSpecification requestSpecification;

    // How to use filter in test.
    // need to define filter in LoggingFilter
    // need to ...
    static{
        RestAssured.filters(new LoggingFilter());
    }
    protected void setAuthToken(String token){
        requestSpecification.header("Authorization","Bearer " + token);
    }

    public BaseService(){
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response  postRequest(Object payload, String endpoint){
        return requestSpecification.body(payload).contentType(ContentType.JSON).post(endpoint);
    }
    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification.body(payload).contentType(ContentType.JSON).put(endpoint);
    }
    protected Response getRequest(String endpoint){
        return requestSpecification.get(endpoint);
    }
}
