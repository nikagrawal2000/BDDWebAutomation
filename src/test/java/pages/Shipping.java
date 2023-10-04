package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonActions.CommonActions;

public class Shipping extends CommonActions {

	public Shipping() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cgv")
	public static WebElement checkBox_TermsCondition;

	@FindBy(css = "button[name='processCarrier']")
	public static WebElement button_ShippingProceedToCheckout;

	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium' and @title='Proceed to checkout']")
	public static WebElement button_SummaryProceedToCheckout;

	@FindBy(css = "td.cart_total span.price")
	public static List<WebElement> eachValueOfProducts;

	@FindBy(css = "#total_product")
	public static WebElement totalValueOfProducts;

	@FindBy(css = ".cart_quantity_delete")
	public static WebElement button_DeleteProduct;

	public void clickOnTermsCondition() {
		click(checkBox_TermsCondition);

	}

	public void clickOnShippingProceedToCheckout() {
		click(button_ShippingProceedToCheckout);

	}

	public void clickOnProceedToCheckout() {
		click(button_SummaryProceedToCheckout);

	}

	public void clickOnDeleteProduct() {
		click(button_DeleteProduct);
		waitForInvisibilityOfElement(button_DeleteProduct);
	}

	public void checkTotal() {
		addAndVerifyTotal(eachValueOfProducts, totalValueOfProducts);
	}

}
