package uk.co.testcraft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;


import java.util.List;

public class FeaturedTourPage extends AbstractPage {
    public FeaturedTourPage (final WebDriver driver) {
        super(driver);
    }

    private static final By adults = By.id("selectedAdults");
    private static final By children = By.id("selectedChild");
    private static final By infants = By.id("selectedInfants");
    private static final By bookNow = By.xpath("/html[1]/body[1]/div[4]/div[3]/div[2]/div[2]/div[1]/form[1]/div[4]/button[1]");
    private static final By fName = By.name("firstname");
    private static final By lName = By.name("lastname");
    private static final By email = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/input[1]");
    private static final By confirmEmail = By.name("confirmemail");
    private static final By phone = By.name("phone");
    private static final By address = By.name("address");
    private static final By guestOneName = By.name("passport[1][name]");
    private static final By guestTwoName = By.name("passport[2][name]");
    private static final By guestThreeName = By.name("passport[3][name]");
    private static final By guestOnePassport = By.name("passport[1][passportnumber]");
    private static final By guestTwoPassport = By.name("passport[2][passportnumber]");
    private static final By guestThreePassport = By.name("passport[3][passportnumber]");
    private static final By guestOneAge = By.name("passport[1][age]");
    private static final By guestTwoAge = By.name("passport[2][age]");
    private static final By guestThreeAge = By.name("passport[3][age]");
    private static final By confirmBookingButton = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/button[1]");

    @FindBy (css = "#s2id_autogen1 > a")
    private WebElement country;



    public void selectParticipants(){
        selectBy(driver.findElement(adults), "1");
        selectBy(driver.findElement(children), "1");
        selectBy(driver.findElement(infants), "1");
        driver.findElement(bookNow).click();
    }

    public void bookAsGuest(String firstname, String lastname, String mail, String mobile, String homeAddress ){
        driver.findElement(fName).sendKeys(firstname);
        driver.findElement(lName).sendKeys(lastname);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(confirmEmail).sendKeys(mail);
        driver.findElement(phone).sendKeys(mobile);
        driver.findElement(address).sendKeys(homeAddress);
        country.click();
        country.sendKeys("United Kingdom");
        country.sendKeys(Keys.RETURN);

        //country.sendKeys(Keys.ENTER);
        //country.submit();

        }


    public void enterGuestDetails(String name, String passport, String age1, String age2, String age3){
        driver.findElement(guestOneName).sendKeys(name);
        driver.findElement(guestTwoName).sendKeys(name);
        driver.findElement(guestThreeName).sendKeys(name);
        driver.findElement(guestOnePassport).sendKeys(passport);
        driver.findElement(guestTwoPassport).sendKeys(passport);
        driver.findElement(guestThreePassport).sendKeys(passport);
        driver.findElement(guestOneAge).sendKeys(age1);
        driver.findElement(guestTwoAge).sendKeys(age2);
        driver.findElement(guestThreeAge).sendKeys(age3);
    }

    public void confirmBooking(){
        driver.findElement(confirmBookingButton).click();

    }


}
