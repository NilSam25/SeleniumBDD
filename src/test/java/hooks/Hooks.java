package hooks;

import config.ConfigReader;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ScreenshotUtil;

public class Hooks {

	@Before
    public void setup(Scenario scenario) {

        ConfigReader.loadProperties();
        DriverFactory.initDriver();

        ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                "START_" + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                "END_" + scenario.getName());

        if (scenario.isFailed()) {

            ScreenshotUtil.captureScreenshot(
                    DriverFactory.getDriver(),
                    "FAILED_" + scenario.getName());
        }

        DriverFactory.quitDriver();
    }
}