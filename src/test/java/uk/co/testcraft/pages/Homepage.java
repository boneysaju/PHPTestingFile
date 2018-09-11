package uk.co.testcraft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Homepage extends AbstractPage {
    public Homepage(final WebDriver driver) {
        super(driver);
    }

    private static final String URL = "https://www.phptravels.net/";
    private static final By signUP = By.cssSelector("#collapse #li_myaccount li:nth-of-type(2) .go-text-right");
    private static final By logIN = By.cssSelector("#collapse #li_myaccount li:nth-of-type(1) .go-text-right");
    private static final By myAccountButton = By.cssSelector("#collapse [class='lightcaret mt-2 go-left']");
    private static final By bookNowButton = By.xpath("/html[1]/body[1]/div[4]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]");

    @FindBy(css = "#collapse > ul:nth-child(1) > li:nth-child(3) > a")
    private WebElement flightsTab;

    @FindBy(css = "#collapse > ul:nth-child(1) > li:nth-child(2) > a")
    private WebElement hotelsTab;


    public void goTo() {
        this.driver.get(URL);
        this.driver.manage().window().maximize();
    }


    public void goToSignUpPage() {
        driver.findElement(myAccountButton).click();
        driver.findElement(signUP).click();
    }

    public void goToLogInPage() {
        driver.findElement(myAccountButton).click();
        driver.findElement(logIN).click();
    }

    public void goToFlightsTab(){
        flightsTab.click();
    }

    public void goToHotelsTab(){
        hotelsTab.click();
    }


    public void selectBookNowButton() {
        driver.findElement(bookNowButton).click();
    }


}
