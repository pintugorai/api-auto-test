package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {
    @Test
    public void updateProfileInfoTest(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("user1","password1"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());

        System.out.println("-------------------------- Fist log ----------------------------------");

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(),"User1");

        System.out.println("-------------------------- Second log ----------------------------------");

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("Pintu")
                .lastName("Gorai")
                .email("adf@gmiail.com")
                .mobileNumber("1254789654")
                .build();

        response = userProfileManagementService.updateProfile(profileRequest,loginResponse.getToken());
        System.out.println(response.asPrettyString());
    }
}
