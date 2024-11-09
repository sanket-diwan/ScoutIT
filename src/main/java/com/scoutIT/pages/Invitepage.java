package com.scoutIT.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;

public class Invitepage extends BasePage {


    @FindBy(xpath= "//li[@id='accountmenu']")
    WebElement Account;

    @FindBy(xpath= "//*[@id='accountmenu']/ul/li[2]/a")
    WebElement ManageUser;

    @FindBy(xpath= "//button[@id='ShowEmailAddressInviteSubmit']")
    WebElement InviteUserButton;

    @FindBy(xpath= "//input[@id='emailAddressInviteInput']")
    WebElement EnterEmail;

    @FindBy(xpath= "//select[@id='select-role-id']/option[2]")
    WebElement SelectRole;

    @FindBy(xpath= "//button[@id='emailAddressInviteSubmit']")
    WebElement SendInvitebutton;

    @FindBy(xpath= "//div[@id='successAlert']")
    WebElement SuccessMessage;

    @FindBy(xpath= "//li[@class='ui-widget-content']")
    WebElement UserId;

    @FindBy(xpath= "//*[@id='InviteUserPopup']/div/div/div[1]/button")
    WebElement Closebutton;

    @FindBy(xpath= "//button[@class='btn btn-danger']")
    WebElement DeleteButton;



    public Invitepage(WebDriver driver) {

        super(driver);
    }


    public  LandingPage Invite(String email) throws Throwable
    {
        Account.click();
        ManageUser.click();
        InviteUserButton.click();
        EnterEmail.sendKeys("Hi@mailinator.com");
        SelectRole.click();
        SendInvitebutton.click();
        Thread.sleep(2000);
        Closebutton.click();
        DeleteButton.click();
        Thread.sleep(5000);
        String Actual_msg=SuccessMessage.getText();
        if(Actual_msg.contains("Invite deleted."))
        {
            System.out.println("Test case pass");
        }
        Thread.sleep(2000);
        return new LandingPage(this.driver);
    }
}
