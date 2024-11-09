package com.scoutIT.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import com.scoutIT.pages.LandingPage;
import com.scoutIT.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.TestDriverManager;
import lombok.extern.log4j.Log4j2;


import java.lang.reflect.Method;




public class BaseTest {

    protected LandingPage landingPage=null;
    protected WebDriver driver;
    static ExtentReports extent;
    Faker faker = new Faker();

    @BeforeSuite
    public void initReporting(){
        extent = new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter("./reports/index.html");
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void flushReports(){
        extent.flush();
    }


    @BeforeMethod
    public void initTest(Method method){

        driver = TestDriverManager.getDriver();

        LoginPage loginPage=new LoginPage(driver);
        landingPage = loginPage.login("Automation@mailinator.com", "Test@123");
    }

    @AfterMethod
    public void tearDown(Method method){
        driver.quit();

    }
}

