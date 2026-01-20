package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    private static final Logger logger = (Logger) LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext context) {
        logger.info("Test Started: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        logger.info("Finished tests in context: " + context.getName());
    }
    public void onTestStarted(ITestResult result){
        logger.info("Started : " + result.getMethod().getMethodName());
        logger.info("Description : " + result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: " + result.getMethod().getMethodName());
        logger.error("Exception: " + result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("Test skipped: " + result.getMethod().getMethodName());
    }


}
