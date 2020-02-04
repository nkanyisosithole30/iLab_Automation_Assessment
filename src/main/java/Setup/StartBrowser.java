package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StartBrowser {
    public static String dir = System.getProperty("user.dir");

    public static final String Chromedriver = dir + "/src/main/java/Drivers/chromedriver.exe";
    public static final String Firefox = dir + "/src/main/java/Drivers/geckodriver.exe";


    static WebDriver driver;

    public static WebDriver startBrowser(String URL,String BrowserChoice) {

        if (BrowserChoice.equalsIgnoreCase("FireFox")) {
            System.setProperty("webdriver.gecko.driver", Firefox);
            driver = new FirefoxDriver();
        } else if (BrowserChoice.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", Chromedriver);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.setExperimentalOption("useAutomationExtension", false);
            driver = new ChromeDriver(options);
        }

        driver.get(URL);
        return driver;
    }
}
