package uk.co.testcraft.stepDefs;

import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.testcraft.Credentials.ValidCredentials;
import uk.co.testcraft.pages.*;

public class PhpSearchStepDefs implements En {
    private WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    Homepage phpPage = new Homepage(driver);
    SignUpPage signUp = new SignUpPage(driver);
    LogInPage logIn = new LogInPage(driver);
    FeaturedTourPage tourPage = new FeaturedTourPage(driver);
    ValidCredentials credentials = new ValidCredentials(driver);
    FlightsPage flights = new FlightsPage(driver);
    HotelsPage hotels = new HotelsPage(driver);


    public PhpSearchStepDefs() {

        Given("^I'm on the phptravel.net main page$", () -> {
            phpPage.goTo();
        });

        When("^I click on Sign up", () -> {
            phpPage.goToSignUpPage();
        });

        And("^I fill out the form$", () -> {
            signUp.fillOutSignUpForm(credentials.fname, credentials.lname, credentials.mobile, credentials.email, credentials.pass);
        });

        Then("^I submit the form$", () -> {
            signUp.clickSignUpButton();
            driver.quit();
        });

        When("^I click on Log in$", () -> {
            phpPage.goToLogInPage();
        });

        And("^I enter my log in details$", () -> {

            logIn.fillOutLogInForm(credentials.email, credentials.pass);
        });

        Then("^I will be on my account page$", () -> {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/h3[1]")));
            Assert.assertTrue(driver.getTitle().contains("My Account"));
            driver.quit();
        });

        When("^I select book now on a featured tour$", () -> {
            phpPage.selectBookNowButton();
        });

        And("^I select the number of people$", () -> {
            tourPage.selectParticipants();
        });

        And("^I fill in my personal details$", () -> {
            tourPage.bookAsGuest(credentials.fname, credentials.lname, credentials.email, credentials.mobile, credentials.address);
            tourPage.enterGuestDetails(credentials.guestName, credentials.passportNumber, "35", "10", "2");
            tourPage.confirmBooking();
        });

        Then("^I will be on the invoice page$", () -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[3]")));
            Assert.assertTrue(driver.getTitle().contains("Invoice"));
            driver.quit();
        });

        When("^I click on the flights tab$", () -> {
            phpPage.goToFlightsTab();
        });

        And("^Search for a flight$", () -> {
            flights.fillOutDestinations("EMA", "GNT");
            flights.selectDate();
            flights.selectNumberOfPassengers();
            flights.changeClass("first");
        });
        And("^I book a flight$", () -> {
            flights.bookFlight();
        });
        And("^I fill in the booking form with valid details$", () -> {
            tourPage.bookAsGuest(credentials.fname, credentials.lname, credentials.email, credentials.mobile, credentials.address);
            flights.confirmBooking();
        });

        When("^I click on the Hotels Tab$", () -> {
            phpPage.goToHotelsTab();
        });

        And("^I fill out the search criteria$", () -> {
            hotels.selectDates("22", "29");
        });

        And("^I fill out valid details$", () -> {
            tourPage.bookAsGuest(credentials.fname, credentials.lname, credentials.email, credentials.mobile, credentials.address);
            hotels.selectConfirmBooking();
        });


        And("^I enter the wrong details$", () -> {
            logIn.fillOutLogInForm(credentials.email , credentials.pass + "wrong");
        });

        Then("^I will be shown an error message$", () -> {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[2]/div")));
            String errorMessage = driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[2]/div")).getText();
            System.out.print("this is the" + errorMessage);
            Assert.assertTrue("The error message was not visible", errorMessage.contains("Invalid") );
            driver.quit();

        });



    }
}
