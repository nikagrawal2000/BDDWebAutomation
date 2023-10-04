package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonActions.CommonActions;

public class Payment extends CommonActions {

	public Payment() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[title='Pay by bank wire']")
	public static WebElement button_PayByBankWire;

	@FindBy(css = "button[type='submit'][class='button btn btn-default button-medium']")
	public static WebElement button_ConfirmOrder;

	@FindBy(css = "p[class='cheque-indent']")
	public static WebElement text_ConfirmOrderMessage;

	public void clickOnPayByBankWire() {
		click(button_PayByBankWire);

	}

	public void clickOnConfirmOrder() {
		click(button_ConfirmOrder);

	}

	public void verifyConfirmOrderMessage(String messageToVerify) {
		verifyMessagePresent(text_ConfirmOrderMessage, messageToVerify);

	}

}
