package drivers;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
    public static WebDriver driver;
    
    private static final Logger logger =
            LogManager.getLogger(DriverFactory.class);

    public static void initDriver() {
    	logger.info("Initializing Chrome Driver");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        logger.info("Chrome Browser Launched Successfully");
    }

    public static WebDriver getDriver() {
    	logger.debug("Returning Driver Instance");
        return driver;
    }

    public static void quitDriver() {
    	logger.info("Closing Browser");
        driver.quit();
        logger.info("Browser Closed");
    }

}
