package com.scoutIT.pages;

import com.scoutIT.util.TestConfigReader;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    final WebDriver driver;

    @FindBy(xpath= "//input[@id='UserName']")
    WebElement txtUserName;

    @FindBy(xpath= "//input[@id='Password']")
    WebElement txtPassword;

    @FindBy(xpath= "//input[@id='login-button']")
    WebElement btnLogin;




    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(TestConfigReader.read("app.url"));
        PageFactory.initElements(driver,this);
    }

    public LandingPage login(String userName, String password) {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
        return new LandingPage(this.driver);
    }

}

