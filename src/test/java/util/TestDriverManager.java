package util;


import com.scoutIT.util.TestConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class TestDriverManager {
    public static WebDriver getDriver() {
        WebDriver driver=null;
        String browserName = TestConfigReader.read("browser.name");

        try {


            switch (browserName.toLowerCase()) {
                case "firefox":
                    driver= new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    driver= new ChromeDriver();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}