package uk.co.testcraft.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightsPage extends AbstractPage {
    public FlightsPage(final WebDriver driver) {
        super(driver);
    }

    public static final By firstResult = By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/div");
    public static final By selectPeople = By.xpath("//input[@placeholder='0']");
    public static final By selectAdults = By.xpath("//*[@id=\"manual_flightTravelers\"]/div/div/div[2]/section/div/div[1]/div[1]/select");
    public static final By guestPagePresent = By.xpath("//*[@id=\"myModalLabel\"]");
    public static final By cabin = By.name("cabinclass");
    public static final By searchButton = By.cssSelector("#body-section > div.search_head > div > form > div.bgfade.col-md-1.col-xs-12.search-button > button");
    public static final By bookNow = By.cssSelector("#bookbtn");
    public static final By confirmBooking = By.cssSelector("#body-section > div > div > div.loadinvoice > div > div.col-md-8.offset-0.go-right > div:nth-child(2) > div.form-group > button");

    @FindBy(css = "#s2id_location_from > a")
    private WebElement fromDestination;

    @FindBy(css = "#s2id_location_to > a")
    private WebElement toDestination;

    @FindBy(css = "#body-section > div.search_head > div > form > div:nth-child(3) > div > input")
    private WebElement fromDate;

    @FindBy(css = "#sumManualPassenger")
    private WebElement doneButton;


    public void fillOutDestinations(String destination1, String destination2) {
        fromDestination.click();
        fromDestination.sendKeys(destination1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResult));
        fromDestination.sendKeys(Keys.RETURN);
        toDestination.click();
        toDestination.sendKeys(destination2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResult));
        toDestination.sendKeys(Keys.ENTER);
    }

    public void selectDate() {
        fromDate.sendKeys("2018-09-14");
        driver.findElement(By.xpath("/html/body/div[8]/div[1]/table/tbody/tr[3]/td[6]")).click();

    }

    public void selectNumberOfPassengers() {
        driver.findElement(selectPeople).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            driver.findElement(guestPagePresent).click();
        }
        driver.findElement(selectAdults).sendKeys("3");
        doneButton.click();
    }

    public void changeClass(String first) {
        selectBy(driver.findElement(cabin), "Business");
        driver.findElement(searchButton).submit();
    }

    public void bookFlight(){
        driver.findElement(bookNow).click();
    }


    public void confirmBooking() {
        driver.findElement(confirmBooking).click();
    }
}
