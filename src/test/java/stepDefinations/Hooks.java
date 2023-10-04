package stepDefinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.GlobalBase;
import utils.ReadConfig;

public class Hooks {

	WebDriver driver;
	public static Logger logger = GlobalBase.getLoggerInstance();
	private static String baseURL = ReadConfig.getInstance().getApplicationURL();

	

	@AfterStep()
	public void screenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				logger.info(scenario.getName() + " is Fail");
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				logger.info(scenario.getName() + " is Pass");
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
