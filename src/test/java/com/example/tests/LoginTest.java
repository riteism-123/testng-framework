package com.example.tests;

import com.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws Exception {
        return ExcelReader.readExcelData("sample.xlsx");
    }

    @Test(dataProvider = "excelData")
    public void loginTest(String username, String password) {
        System.out.println("Testing login with Username: " + username + ", Password: " + password);
        // You can replace this with actual login logic
    }
}
