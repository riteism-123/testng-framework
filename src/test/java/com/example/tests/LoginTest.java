package com.example.tests;

import com.example.utils.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest  extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws Exception {
        return ExcelReader.readExcelData("sample.xlsx");
    }

    @Test(dataProvider = "excelData")
    public void loginTest(String username, String password) {
        System.out.println("Testing login with Username: " + username + ", Password: " + password);
        // You can replace this with actual login logic
        
        
    }
    
    @Test
    public void loginTest() {
    	logger.info("Starting login test...");
    	
        test = BaseTest.extent.createTest("Login Test");
        
        logger.debug("Opening login page");
        logger.info("Entering valid credentials");
        logger.warn("This is a warning if element is slow");
        logger.error("Sample error if login fails");

        test.pass("Login was successful");
        logger.info("Login test completed ✅");
        
        
        
    }
    
    

}
