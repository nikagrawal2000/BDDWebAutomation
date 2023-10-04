package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonActions.CommonActions;

public class Catalog extends CommonActions {

	public Catalog() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='product-container']/div[2]/h5/a")
	public static List<WebElement> list_ofProducts;

	public void selectProductFromCatalog(String product) {
		addProductFromList(list_ofProducts, product);

	}

	public void selectProductFromCategory(String product) {
		selectMatchedProductFromList(list_ofProducts, product);

	}

	public void selectProductByPopularity(String product) {
		addProductFromPopularList(list_ofProducts, product);

	}

}
