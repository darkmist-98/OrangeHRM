package com.darkmist.pages;

import com.darkmist.base.Base;
import com.darkmist.helper.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;
    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doUserLogin(String givenUsername,String givenPassword) {
        Utility.elementWait(driver,username);
        Utility.elementWait(driver,password);
        username.sendKeys(givenUsername);
        password.sendKeys(givenPassword);
        loginButton.click();
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
}
