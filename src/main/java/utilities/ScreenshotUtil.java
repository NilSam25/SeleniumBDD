package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    public static String captureScreenshot(
            WebDriver driver,
            String scenarioName) {

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        String destination =
                "screenshots/"
                + scenarioName.replace(" ", "_")
                + "_"
                + System.currentTimeMillis()
                + ".png";

        try {
            Files.copy(
                    source.toPath(),
                    new File(destination).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }
}
