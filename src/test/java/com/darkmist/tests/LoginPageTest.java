package com.darkmist.tests;

import com.darkmist.base.Base;
import com.darkmist.helper.ConfigReader;
import com.darkmist.helper.WebDriverFactory;
import com.darkmist.pages.DashboardPage;
import com.darkmist.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Test(description = "<b>Verify Page Title coming as</b> <b><i>OrangeHRM</i></b>")
    public void verifyPageTitle() {
        driver.get(getBaseUrl());
        loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getPageTitle(),"OrangeHRM",
                "Page Title did not match");
    }

    @Test(description = "<b>Verify Login with valid credentials</b>")
    public void verifyValidLogin() {
        driver.get(getBaseUrl());
        loginPage = new LoginPage(driver);
        loginPage.doUserLogin(ConfigReader.getPropertyValue("username"),
                ConfigReader.getPropertyValue("password"));
        dashboardPage = new DashboardPage(driver);
        dashboardPage.getPageTag();
    }
}
