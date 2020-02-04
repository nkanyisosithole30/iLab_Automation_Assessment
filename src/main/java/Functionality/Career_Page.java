package Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Career_Page {
    WebDriver driver;
    public Career_Page(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy(linkText = "South Africa")
    WebElement Country_Link;

    @FindBy(linkText = "Senior Test Automation Specialist – Johannesburg")
    WebElement First_Position;

    public void Click_Country()
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Country_Link)).click();
    }
    public void Click_First_Position()
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(First_Position)).click();
    }
}
