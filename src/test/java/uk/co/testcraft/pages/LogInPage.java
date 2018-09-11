package uk.co.testcraft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends AbstractPage {
    public LogInPage (final WebDriver driver) {
        super(driver);
    }

    private static final By username = By.name("username");
    private static final By registeredUserPassword = By.cssSelector("#loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > div > div:nth-child(2) > input");
    private static final By logInButton = By.cssSelector("#loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > button");

    public void fillOutLogInForm(String email, String pass) {
        driver.findElement(username).sendKeys(email);
        driver.findElement(registeredUserPassword).sendKeys(pass);
        driver.findElement(logInButton).click();
    }


}
