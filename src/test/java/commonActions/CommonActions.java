package commonActions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalBase;

public class CommonActions {

	public static WebDriver driver = GlobalBase.getDriverInstance();
	public static Logger logger = GlobalBase.getLoggerInstance();

	public static void click(WebElement webElement) {
		try {

			webElement.click();
			logger.info("Element Present and clicked successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendText(WebElement webElement, String valueToSend) {
		try {

			webElement.clear();
			webElement.sendKeys(valueToSend);
			logger.info("Element Present and entered value successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDropdown(WebElement webElement, String valueToSelect) {
		try {
			Select select = new Select(webElement);
			select.selectByVisibleText(valueToSelect);
			logger.info("Element Present and selected vale form dropdown successfully");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectDropdownByValue(WebElement webElement, String valueToSelect) {
		try {
			Select select = new Select(webElement);
			select.selectByValue(valueToSelect);
			logger.info("Element Present and selected vale form dropdown successfully");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterValue(WebElement webElement, String valueToSend) {
		try {

			webElement.clear();
			webElement.sendKeys(valueToSend);
			logger.info("Element Present and entered value successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addProductFromList(List<WebElement> elementList, String productName) {
		try {
			for (WebElement ele : elementList) {
				System.out.println(ele.getText());
				if (ele.getText().contains(productName)) {
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,501)");
					hoverOnElement(driver, ele);
					break;

				}

			}

			WebElement e = driver.findElement(By.xpath("//*[@id='blockbestsellers']//a[contains(text(),'" + productName
					+ "')]/parent::*/following-sibling::*[@class='button-container']/a/span[text()='Add to cart']"));
			e.click();
			logger.info("Element Present and selected matching element successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addProductFromPopularList(List<WebElement> elementList, String productName) {
		try {
			for (WebElement ele : elementList) {
				System.out.println(ele.getText());
				if (ele.getText().contains(productName)) {
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,501)");
					hoverOnElement(driver, ele);
					break;

				}

			}

			WebElement e = driver.findElement(By.xpath("//*[@id='homefeatured']//a[contains(text(),'" + productName
					+ "')]/parent::*/following-sibling::*[@class='button-container']/a/span[text()='Add to cart']"));
			e.click();
			logger.info("Element Present and selected matching element successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForInvisibilityOfElement(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOf(ele));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addAndVerifyTotal(List<WebElement> elementList, WebElement totalValue) {
		try {
			double val = 0.0;
			double totalval = 0.0;
			for (WebElement ele : elementList) {
				if (ele.getText().startsWith("$")) {
					val = val + new Double(ele.getText().substring(1));
				} else {
					throw new Exception("not a valid dollar value");
				}
			}
			if (totalValue.getText().startsWith("$")) {
				totalval = new Double(totalValue.getText().substring(1));
			}

			assertEquals(val, totalval, 0);
			logger.info("Total value of product(s) matches successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectMatchedProductFromList(List<WebElement> elementList, String productName) {
		try {
			for (WebElement ele : elementList) {
				if (ele.getText().contains(productName)) {
					javaScriptClick(ele);
					break;
				}

			}
			logger.info("Element Present and selected matching element successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollIntoView(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	public static void hoverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public static void javaScriptClick(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public static void verifyMessagePresent(WebElement element, String textToVerify) {
		assertEquals(element.getText(), textToVerify);
		logger.info("Message present on screen and verified successfully");

	}

}
