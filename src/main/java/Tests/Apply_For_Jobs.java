package Tests;

import Functionality.Apply_Page;
import Functionality.Career_Page;
import Functionality.Home_Page;
import Helpers.Generate_Extent_Report;
import Helpers.Generate_Phone_Number;
import Setup.StartBrowser;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Apply_For_Jobs extends Generate_Extent_Report {

    private static String dir=System.getProperty("user.dir");
    public static final String excel = dir+"/src/main/java/Test_Data/TestData.xlsx";

    private Generate_Phone_Number number=new Generate_Phone_Number();
    String phone_no=number.getRandomNumber();

    private WebDriver driver= StartBrowser.startBrowser("https://www.ilabquality.com/","chrome");

    private Home_Page home= PageFactory.initElements(driver,Home_Page.class);
    Career_Page career=PageFactory.initElements(driver,Career_Page.class);
    Apply_Page apply=PageFactory.initElements(driver,Apply_Page.class);
    public Apply_For_Jobs()
    {

    }
    @Test(description="This test when running will apply for first available position using data from the excel data sheet")
    public void Apply_For_First_Position() throws IOException {
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String Name = sheet.getRow(1).getCell(0).getStringCellValue();
        String Email = sheet.getRow(1).getCell(1).getStringCellValue();
        String WhyWorkForiLab = sheet.getRow(1).getCell(3).getStringCellValue();
        test = extent.createTest("Apply For First Job", "Application");
        test.log(Status.PASS, "Verify that an error message is when applying with missing mandatory fields");
        home.Click_Career_Link();
        test.log(Status.PASS,"Click Careers Link");
        career.Click_Country();
        test.log(Status.PASS,"Select Country");
        career.Click_First_Position();
        test.log(Status.PASS,"Select First Position");
        apply.Click_Apply_Online_Link();
        test.log(Status.PASS,"Click Apply Online Link");
        apply.Enter_Name(Name);
        test.log(Status.PASS,"Populate Name");
        apply.Enter_Email_Address(Email);
        test.log(Status.PASS,"Populate email address");
        Generate_Phone_Number number=new Generate_Phone_Number();
        apply.Enter_Phone_Number(number.getRandomNumber());
        test.log(Status.PASS,"Getting Random Numbers for phone number");
        apply.Why_Work_For_Ilab(WhyWorkForiLab);
        test.log(Status.PASS,"Populate the Why Work For ILab box");
        apply.Click_Send_ApplicationButton();
        test.log(Status.PASS,"Click Send Application Button");
        apply.Validate_Error_Label();
        test.log(Status.PASS,"Validate error ");

    }
    @AfterTest
    public void Quit_Test()
    {
        driver.quit();
    }

}
