package com.darkmist.pages;

import com.darkmist.helper.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    private WebDriver driver;

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    private WebElement dashboardText;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void getPageTag() {
        Utility.elementWait(driver,dashboardText);
        System.out.println(dashboardText.getText());
    }
}
