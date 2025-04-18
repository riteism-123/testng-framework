package com.example.tests;

import org.testng.annotations.Test;

import com.example.utils.JsonDataProvider;

public class LoginUsingJson {

    @Test(dataProvider = "jsonData", dataProviderClass = JsonDataProvider.class)
    public void loginTest(String username, String password) {
        System.out.println("Logging in with: " + username + " / " + password);
        // Add your Selenium or API login logic here
    }
}
