package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonActions.CommonActions;

public class ContinueOrCheckout extends CommonActions {

	public ContinueOrCheckout() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#binBtn_btn")
	public static WebElement btn_BuyNow;

	@FindBy(css = "#atcRedesignId_btn")
	public static WebElement btn_AddToCart;

	@FindBy(css = ".btn.btn-prim.vi-VR-btnWdth-XL.w-100")
	public static WebElement btn_GoToCart;

	@FindBy(css = "div[role='button']")
	public static WebElement btn_CloseOnGoToCardWindow;

	@FindBy(css = "span[title='Continue shopping']")
	public static WebElement button_ContinueShopping;

	@FindBy(css = "a[title='Proceed to checkout']")
	public static WebElement button_ProceedToCheckout;

	public void clickContinueShopping() {
		click(button_ContinueShopping);

	}

	public void clickProceedToCheckout() {
		click(button_ProceedToCheckout);

	}

}
