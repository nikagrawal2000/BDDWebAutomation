package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonActions.CommonActions;

public class ProdDetails extends CommonActions {

	public ProdDetails() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add to cart']")
	public static WebElement button_ProductDetailAddToCart;

	public void clickOnProductDetailAddToCart() {
		click(button_ProductDetailAddToCart);

	}
	
	public void addTshirt(int noOfTimes)
	{
		
	}
}
