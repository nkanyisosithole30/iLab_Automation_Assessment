package Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Apply_Page {
    WebDriver driver;
    public Apply_Page(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy(xpath = "//a[contains(.,'Apply Online')]")
    WebElement Apply_Online_Link;

    @FindBy(id ="applicant_name")
    WebElement Name;

    @FindBy(id ="email")
    WebElement Email_Address;

    @FindBy(id ="phone")
    WebElement Phone_Number;

    @FindBy(id ="message")
    WebElement Why_Workfor_Ilab;

    @FindBy(xpath ="//*[@id=\"wpjb_submit\"]")
    WebElement Send_Application_Button;

    @FindBy(xpath ="//*[@id=\"wpjb-apply-form\"]/fieldset[1]/div[5]/div/ul/li")
    WebElement Error_Label;

    public void Click_Apply_Online_Link()
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Apply_Online_Link)).click();
    }
    public void Enter_Name(String Names)
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Name)).sendKeys(Names);
    }
    public void Enter_Email_Address(String Email)
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Email_Address)).sendKeys(Email);
    }
    public void Enter_Phone_Number(String Number)
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Phone_Number)).sendKeys(Number);
    }
    public void Why_Work_For_Ilab(String whyWork)
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Why_Workfor_Ilab)).sendKeys(whyWork);
    }
    public void Click_Send_ApplicationButton()
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Send_Application_Button)).click();
    }
    public void Validate_Error_Label()
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Error_Label));
        Assert.assertEquals(Error_Label.getText(), "You need to upload at least one file.");
    }
}
