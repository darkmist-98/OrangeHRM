package com.darkmist.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.darkmist.constants.FrameworkConstant;

import java.io.File;
import java.net.InetAddress;
import java.util.Objects;

public final class ExtentReportConfig {

    private static final ExtentSparkReporter sparkReporter = new ExtentSparkReporter
            (FrameworkConstant.EXTENT_REPORT_FILE_PATH).viewConfigurer().viewOrder()
            .as(new ViewName[]{ViewName.DASHBOARD,ViewName.TEST,ViewName.EXCEPTION}).apply();

    private static ExtentReports extentReports;

    /**
     * This method to initiate Extent Report
     */
    public static void initExtentReport() {
        try {
            if (Objects.isNull(extentReports)) {
                extentReports = new ExtentReports();
                extentReports.attachReporter(sparkReporter);
                extentReports.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
                extentReports.setSystemInfo("Environment","Development");
                extentReports.setSystemInfo("User Name","Darkmist");
                sparkReporter.loadJSONConfig(new File(FrameworkConstant.EXTENT_CONFIG_FILE_PATH));
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method to close report with all required data
     */
    public static void flushExtentReport() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        ExtentManager.unload();
    }

    /**
     * This method to Create Test for every new Test method execution
     */
    public static void createTest(String testcaseName,String description) {
        ExtentManager.setExtentTest(extentReports.createTest(testcaseName,description));
    }
}
