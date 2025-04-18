package com.example.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    public static ExtentReports extent;
    public static ExtentTest test;
    
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setupReport() {
    	  logger.info("Setting up Extent Report");
    	
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}
