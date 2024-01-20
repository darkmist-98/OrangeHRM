package com.darkmist.base;

import com.darkmist.helper.ConfigReader;
import com.darkmist.helper.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Initialize the WebDriver
        driver = WebDriverFactory.getDriver();
    }
    @AfterMethod
    public void tearDown() {
        //Close the browser window and remove the instance
        WebDriverFactory.quitDriver();
    }

    public static String getBaseUrl() {
        return ConfigReader.getPropertyValue("base_url");
    }
}
