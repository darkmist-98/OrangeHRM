package com.darkmist.report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.darkmist.base.Base;
import com.darkmist.helper.Utility;
import org.testng.ITestResult;

public class ExtentLogger {

    //private static WebDriver driver;

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }
    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }
    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(MarkupHelper.createLabel(message, ExtentColor.YELLOW));
    }
    public static void logInfo(String message) {
        ExtentManager.getExtentTest().info(message);
    }
    public static void logThrowable(ITestResult result) {
        ExtentManager.getExtentTest().info(result.getThrowable());
    }
    public static void captureFailureScreenShot() {
        //driver = WebDriverFactory.getDriver();
        ExtentManager.getExtentTest().log(Status.INFO, MediaEntityBuilder
                .createScreenCaptureFromBase64String(Utility.captureScreenshotAsBase64(Base.getDriver()))
                .build());
    }
}
