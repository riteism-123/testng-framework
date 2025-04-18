package com.example.utils;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("🟡 Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("❌ Test Failed: " + result.getName());
        logger.error("Error: " + result.getThrowable());

        // Optionally: take screenshot
        // ScreenshotUtil.capture(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⚠️ Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("=== Test Suite Started: " + context.getName() + " ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("=== Test Suite Finished: " + context.getName() + " ===");
    }
}
