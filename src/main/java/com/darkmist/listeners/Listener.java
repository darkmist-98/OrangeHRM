package com.darkmist.listeners;

import com.darkmist.report.ExtentLogger;
import com.darkmist.report.ExtentReportConfig;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReportConfig.initExtentReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReportConfig.flushExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportConfig.createTest(result.getMethod().getMethodName(), result.getMethod()
                .getDescription());
        ExtentLogger.logInfo(result.getMethod().getMethodName() + " is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
        ExtentLogger.captureFailureScreenShot();
        ExtentLogger.logThrowable(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
    }
}
