package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonActions.CommonActions;

public class Home extends CommonActions {

	public Home() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='search_query_top']")
	public static WebElement textBox_Search;

	@FindBy(css = "button[type='submit'][name='submit_search']")
	public static WebElement button_Search;

	@FindBy(css = "a[title='Proceed to checkout']")
	public static WebElement button_HomeCheckout;

	@FindBy(xpath = "//div[@class='ac_results']/ul/li")
	public static List<WebElement> text_SelectProduct;

	@FindBy(xpath = "//a[text()='Women']")
	public static WebElement button_SearchProductByWomenCategory;

	@FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]")
	public static WebElement button_SearchProductByDressCategory;

	@FindBy(xpath = "//a[text()='Popular']")
	public static WebElement button_SearchByPopularProducts;

	@FindBy(xpath = "//a[text()='Best Sellers']")
	public static WebElement button_SearchByBestSellers;

	public void enterProceedToSearch(String valueToSend) {

		enterValue(textBox_Search, valueToSend);

	}

	public void clickOnSearchButton() {
		click(button_Search);

	}

	public void clickOnHomeCheckout() {
		click(button_HomeCheckout);

	}

	public void selectProduct(String productName) {
		selectMatchedProductFromList(text_SelectProduct, productName);

	}

	public void clickOnSearchProductByWomenCategory() {
		click(button_SearchProductByWomenCategory);

	}

	public void clickOnSearchProductByDressCategory() {
		click(button_SearchProductByDressCategory);

	}

	public void clickOnSearchByPopularProducts() {
		click(button_SearchByPopularProducts);

	}

	public void clickOnSearchByBestSellers() {
		click(button_SearchByBestSellers);

	}

}
