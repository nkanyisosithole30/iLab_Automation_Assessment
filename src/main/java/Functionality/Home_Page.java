package Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {
    WebDriver driver;

    public Home_Page(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy(xpath = "//*[@id=\"menu-item-1373\"]/a[1]")
    WebElement Career_Link;


    public void Click_Career_Link()
    {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(Career_Link)).click();
    }
}
