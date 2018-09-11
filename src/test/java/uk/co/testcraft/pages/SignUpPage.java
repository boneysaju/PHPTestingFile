package uk.co.testcraft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpPage extends AbstractPage {
    public SignUpPage(final WebDriver driver) {
        super(driver);
    }

    private static final By firstName = By.name("firstname");
    private static final By lastName = By.name("lastname");
    private static final By mobileNumber = By.name("phone");
    private static final By eMail = By.name("email");
    private static final By password = By.name("password");
    private static final By confirmPassword = By.name("confirmpassword");
    private static final By signUpButton = By.xpath("/html[1]/body[1]/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[9]/button[1]");


    public void fillOutSignUpForm(String frstName, String scndName, String number, String mail, String pass) {
        driver.findElement(firstName).sendKeys(frstName);
        driver.findElement(lastName).sendKeys(scndName);
        driver.findElement(mobileNumber).sendKeys(number);
        driver.findElement(eMail).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickSignUpButton(){
        driver.findElement(signUpButton).click();
    }
}
