package com.darkmist.base;

import com.darkmist.helper.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeTest
    public void initBrowser() {
        setDriver();
    }
    @AfterTest
    public void closeBrowser() {
        getDriver().close();
        getDriver().quit();
    }

    public static void setDriver() {
        String browser = ConfigReader.getPropertyValue("browser");
        if (browser.toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driverThreadLocal.set(new ChromeDriver());
        } else if (browser.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driverThreadLocal.set(new FirefoxDriver());
        } else {
            throw new IllegalArgumentException("Invalid browser specified in Config file");
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static String getBaseUrl() {
        return ConfigReader.getPropertyValue("base_url");
    }
}
