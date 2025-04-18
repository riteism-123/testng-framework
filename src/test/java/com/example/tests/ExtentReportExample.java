package com.example.tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportExample {

    public static void main(String[] args) {
        // Create a reporter to generate the report
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

        // Create the main report object and attach the reporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        // Create test entries
        ExtentTest test = extent.createTest("Login Test")
                                .info("Starting Login Test")
                                .pass("Login Successful");

        ExtentTest failedTest = extent.createTest("Signup Test")
                                      .fail("Signup Failed");

        // Write everything to the report
        extent.flush();
    }
}
