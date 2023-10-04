package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonActions.CommonActions;

public class ManageAddress extends CommonActions {

	public ManageAddress() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_address_delivery")
	public static WebElement dropDown_ChooseDeliveryAddress;

	@FindBy(css = "textarea[name='message']")
	public static WebElement textBox_EnterCommentMessage;

	@FindBy(xpath = "//button[@type='submit' and @name='processAddress']")
	public static WebElement button_AddressProceedToCheckout;

	public void chooseDeliveryAddress(String valueToSelect) {
		selectDropdown(dropDown_ChooseDeliveryAddress, valueToSelect);

	}

	public void enterCommentMessage(String valueToSend) {
		enterValue(textBox_EnterCommentMessage, valueToSend);

	}

	public void clickAddressProceedToCheckout() {
		click(button_AddressProceedToCheckout);

	}

}
