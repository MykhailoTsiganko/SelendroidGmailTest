package com.epam.lab.selendroid;


import com.epam.lab.selendroid.pages.GmailLoginPage;
import com.epam.lab.selendroid.utils.DriverSingeltone;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppTest {
    @Test
    private void login() throws Exception {
        GmailLoginPage loginPage = new GmailLoginPage();
        loginPage.typeLogin("SelTestTsyganko@gmail.com");

        loginPage.typePassword("Selenium1");

        Assert.assertTrue(loginPage.isLoggined());
        DriverSingeltone.closeDriver();
    }
}
