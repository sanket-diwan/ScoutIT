package com.scoutIT.test;

import com.scoutIT.pages.AppPage;
import com.scoutIT.pages.BasePage;
import com.scoutIT.pages.Invitepage;
import com.scoutIT.pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class InviteTest extends BaseTest {



    @Test
    public void InviteUser() throws Throwable {
        Invitepage invitepage=new Invitepage(super.driver);
        LandingPage landingPage=invitepage.Invite("hi@mailinator.com");


    }
}
