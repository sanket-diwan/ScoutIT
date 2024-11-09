package com.scoutIT.pages;

import com.scoutIT.util.TestConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppPage extends BasePage {

 //   final WebDriver driver;

    @FindBy(xpath= "//li[@id='manageitmenu']")
    WebElement ManageIT;

    @FindBy(xpath= "//li[@id='manageapps']")
    WebElement ManageApps;

    @FindBy(xpath= "//div[@id='PersonalApp_01']")
    WebElement AddButton;

    @FindBy(xpath= "//input[@id='txtAppName']")
    WebElement APPName;

    @FindBy(xpath= "//input[@id='txtAppURL']")
    WebElement APPURL;

    @FindBy(xpath= "//input[@id='txtDescription']")
    WebElement AppDescription;

    @FindBy(xpath= "//input[@id='isActive']")
    WebElement AppCheck;

    @FindBy(xpath= "//input[@id='AllSelector0_selectorval']")
    WebElement Value1;

    @FindBy(xpath= "//input[@id='AllSelector1_selectorval']")
    WebElement Value2;
    @FindBy(xpath= "//input[@id='AllSelector2_selectorval']")
    WebElement Value3;

    @FindBy(xpath = "//*[@id=\"btnAppSave\"]")
    WebElement Submit;

    @FindBy(xpath = "//input[@id='0_parametervalue']")
    WebElement Param1;
    @FindBy(xpath = "//input[@id='1_parametervalue']")
    WebElement Param2;
    @FindBy(xpath = "//input[@id='2_parametervalue']")
    WebElement Param3;


    public AppPage(WebDriver driver) {

        super(driver);
    }

    public LandingPage App(String appurl,String appname, String description,String value1,String value2,String value3,String param1,String param2) throws InterruptedException {
        ManageIT.click();
        ManageApps.click();
        AddButton.click();
        APPURL.sendKeys(appurl);
        APPName.sendKeys(appname);
        AppDescription.sendKeys(description);
        AppCheck.click();
        Value1.sendKeys(value1);
        Value2.sendKeys(value2);
        Value3.sendKeys(value3);
        Param1.sendKeys(param1);
        Param2.sendKeys(param2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Submit.click();
        Thread.sleep(5000);
        return new LandingPage(this.driver);

    }





}
