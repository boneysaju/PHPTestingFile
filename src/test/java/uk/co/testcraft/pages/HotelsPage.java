package uk.co.testcraft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static uk.co.testcraft.pages.FlightsPage.firstResult;

public class HotelsPage extends AbstractPage {
    public HotelsPage(final WebDriver driver) {
        super(driver);
    }

    public static final By searchButton = By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[5]/button");
    public static final By detailsButton = By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[1]/td/div[3]/a/button");
    public static final By bookNowButton = By.xpath("//*[@id=\"ROOMS\"]/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/button");
    public static final By confirmBooking = By.xpath("//*[@id=\"body-section\"]/div/div/div[1]/div/div[1]/div[2]/div[4]/button");

    @FindBy(css = "#s2id_autogen1 > a")
    private WebElement hotelName;

    @FindBy(css = "#dpd1 > div > input")
    private WebElement checkInDate;

    @FindBy(css = "#dpd2 > div > input")
    private WebElement checkOutDate;

    public void selectDates(String startDate, String endDate) {
        hotelName.click();
        hotelName.sendKeys("Rendez");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstResult));
        hotelName.sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input")).click();

        List<WebElement> allDates = driver.findElements(By.xpath("//html/body/div[8]/div[1]/table/tbody/*"));

        for (WebElement cal : allDates) {
            String date = cal.getText();
            System.out.print(date);

            if (date.contains(startDate)) {
                cal.findElements(By.xpath("//td[contains(text(), '" + startDate + "')]")).get(0).click();
                break;
            }
        }


        driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input")).click();

        List<WebElement> allDates2 = driver.findElements(By.xpath("/html/body/div[9]/div[1]/table/tbody/*"));

        for (WebElement cal : allDates) {
            String date = cal.getText();
            System.out.print(date);

            if (date.contains(endDate)) {
                cal.findElements(By.xpath("//td[contains(text(), '" + endDate + "')]")).get(0).click();
                break;
            }
        }

        driver.findElement(searchButton).click();
        driver.findElement(detailsButton).click();
        driver.findElement(bookNowButton).click();
    }

    public void selectConfirmBooking() {
        driver.findElement(confirmBooking).click();
    }


}
