package cucumber.Options;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.GlobalBase;
import utils.PageObjects;
import utils.ReadConfig;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", plugin = { "pretty", "json:target/cucumber-reports/cucumber.json",
		"html:target/cucumber/report.html", "junit:target/cucumber-reports/cucumber-report.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/" }, glue = { "stepDefinations" }, monochrome = true, tags = "@tc1", dryRun = false)

public class TestRunner {
	static WebDriver driver;
	public static Logger logger = GlobalBase.getLoggerInstance();
	private static String baseURL = ReadConfig.getInstance().getApplicationURL();
	static PageObjects pageobj = PageObjects.getInstance();

	@BeforeClass
	public static void setup() throws Exception {
		driver = GlobalBase.getDriverInstance();
		logger.info("======Starting Test============");
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
		pageobj.login().loginWithExistingCust();
	}
	
	@AfterClass
	public static void teardown() throws InterruptedException {
		logger.info("===========All Test Completed, quitting driver===========");
		driver.quit();
	}

}
