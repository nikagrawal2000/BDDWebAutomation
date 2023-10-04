package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonActions.CommonActions;
import utils.ReadConfig;

public class Login extends CommonActions {

	public Login() {
		PageFactory.initElements(driver, this);
	}
			
    @FindBy(css = "a[href='/login']")
	public static WebElement link_Login;

	@FindBy(css = "input[data-qa='login-email']")
	public static WebElement textBox_Email;

	@FindBy(css = "input[placeholder='Password']")
	public static WebElement textBox_Password;
	
	@FindBy(css = "button[data-qa='login-button']")
	public static WebElement button_LogIn;

	public void loginWithExistingCust() {
		click(link_Login);
		sendText(textBox_Email, ReadConfig.getInstance().getUsername());
		sendText(textBox_Password, ReadConfig.getInstance().getPassword());
		click(button_LogIn);
	}
}
