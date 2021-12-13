package Utility;

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {

    public static WebDriver driver;

    public static WebDriver assignWebDriver (Scenario scenario) {

        //based on the operating system we will assign the correct web driver
        String os = System.getProperty("os.name").toLowerCase();

        //based on the scenario name, we can assign either chrome or firefox driver
        if (os.contains("win"))  {
            if (scenario.getName().toLowerCase().contains("chrome"))
            { System.setProperty("webdriver.chrome.driver", Constant.windowsChromeDriverPath);
                driver = new ChromeDriver();
            }
            else if (scenario.getName().toLowerCase().contains("firefox"))
            { System.setProperty("webdriver.gecko.driver", Constant.windowsFirefoxDriverPath);
                driver = new FirefoxDriver();
            }

        } else if (os.contains("mac")) {
            if (scenario.getName().toLowerCase().contains("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", Constant.macChromeDriverPath);
                driver = new ChromeDriver();
            }
            else if (scenario.getName().toLowerCase().contains("firefox"))
            {
                System.setProperty("webdriver.gecko.driver", Constant.macFirefoxDriverPath);
                driver = new FirefoxDriver();
            }
        }

        return driver;
    }
}
