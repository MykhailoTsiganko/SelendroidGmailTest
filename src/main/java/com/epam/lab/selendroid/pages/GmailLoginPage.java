package com.epam.lab.selendroid.pages;

import com.epam.lab.selendroid.utils.DriverSingeltone;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {
    private static final String LOGIN_URI = "https://mail.google.com/mail/";
    @FindBy(name = "identifier")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInpurt;



    public GmailLoginPage() {

        try {
            DriverSingeltone.getDriver().get(LOGIN_URI);
            PageFactory.initElements(DriverSingeltone.getDriver(), this);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void typeLogin(String login) {
        try {
            new WebDriverWait(DriverSingeltone.getDriver(), 20).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("identifier")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        loginInput.sendKeys(login + Keys.RETURN);
    }

    public void typePassword(String login) {
        try {
            new WebDriverWait(DriverSingeltone.getDriver(), 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("password")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        passwordInpurt.sendKeys(login + Keys.RETURN);
    }

    public boolean isLoggined() throws Exception {
        WebElement views = DriverSingeltone.getDriver().findElement(By.id("views"));

        return views != null;
    }


}
