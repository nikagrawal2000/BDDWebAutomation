package utils;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalBase {

	private static WebDriver driver;
	private static Logger logger;

	public static ReadConfig readConfig = ReadConfig.getInstance();
	private static String browserName;

	private GlobalBase() {
		initialization();
	}

	public static WebDriver getDriverInstance() {

		if (driver == null)
			new GlobalBase();
		else
			return driver;

		return driver;
	}

	public static Logger getLoggerInstance() {
		if (driver == null)
			new GlobalBase();

		return logger;
	}

	private static void setDriver(WebDriver driver) {
		GlobalBase.driver = driver;
	}

	@SuppressWarnings("deprecation")
	public static void initialization() {
		logger = Logger.getLogger("E-Commerce Test");
		PropertyConfigurator.configure("log4j.properties");
		browserName = readConfig.getBrowser();
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-features=VizDisplayCompositor");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			ieCapabilities.setCapability("disable-popup-blocking", true);
			ieCapabilities.setCapability("enablePersistentHover", true);
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver(ieCapabilities);
		} else {
			logger.error("Provide proper browser name in config properties");
		}

		driver.manage().window().maximize();
		int timeout = readConfig.getImplicitTimeout();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		setDriver(driver);
	}
}
