package pageobject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class SearchPageObject {
	WebDriver driver;
	Scenario scn;


	private By product_List = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

	private By click_on_product = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

	private By add_to_cart = By.xpath("//input[@id='add-to-cart-button']");

	// with exchange
	private By click_onExchange_btn = By.xpath("(//a[@class='a-accordion-row a-declarative accordion-header'])[1]");

	// choose phone
	private By choose_phone_to_exchange = By.xpath("//input[@aria-labelledby='chooseButton-announce']");

	// select brand
	private By choose_brand = By.xpath("(//span[@class='a-button-text a-declarative'])[2]");

	// select model
	private By choose_model = By.xpath("(//span[@class='a-button-text a-declarative'])[37]");

	// exchange value will appear
	private By exchange_value = By.id("buyBackOfferAppliedSuccessText");
	
	// change the specification 
	private By change_specification = By.xpath("(//span[@class='a-size-base'])[9]");
	
	// click on one year damage protection
	private By click_on_damage_protection = By.xpath("//input[@id='mbb-offeringID-1']");

	public SearchPageObject(WebDriver driver,Scenario scn) {
		this.scn = scn;
		this.driver = driver;
	}

	public void ValidateProductList(String ProductName) {
		List<WebElement> list_of_products = driver.findElements(product_List);

		for (int i = 0; i < list_of_products.size(); i++) {
			if (list_of_products.get(i).getText().toLowerCase().contains(ProductName.toLowerCase())) {
				Assert.assertTrue(true);
			} else {
				Assert.assertFalse(
						"product no correctly displayed in the search result.product at index:-" + ProductName, false);
			}
		}

	}

	public void UserClickOnAnyProduct() {
		WebDriverWait wait = new WebDriverWait(driver, 60);

		Actions action = new Actions(driver);

		List<WebElement> List_of_product = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		for (int i = 1; i <= List_of_product.size(); i++)
			action.moveToElement(wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"))))
			.build().perform();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"))).click();

	}

	public void UserClickOnAddToCartBtn() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentwindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

	}

	public void UserClickedOnExchangeBtn() {
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> iterator1 = handles1.iterator();
		String parentWind = iterator1.next();
		String childWind = iterator1.next();
		driver.switchTo().window(childWind);
		driver.findElement(By.xpath("(//a[@class='a-accordion-row a-declarative accordion-header'])[1]")).click();

	}

	public void UserClickedOnChoosePhoneToExchange() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions action = new Actions(driver);

		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@aria-labelledby='chooseButton-announce']")))).build()
		.perform();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-labelledby='chooseButton-announce']")))
		.click();

	}

	public void UserSelectBrand_ModelOfMobile() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions action = new Actions(driver);

		Set<String> first_childWindow = driver.getWindowHandles();
		Iterator<String> iterator2 = first_childWindow.iterator();
		String first_childWindo = iterator2.next();
		String second_childWindow = iterator2.next();
		driver.switchTo().window(second_childWindow);

		// this is for brand of mobile
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@class='a-button-text a-declarative'])[2]")))).build()
		.perform();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-button-text a-declarative'])[2]")))
		.click();

		WebElement dropdown_value = driver.findElement(By.id("buyBackDropDown1_33"));
		dropdown_value.click();

		// this for model of the mobile
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@class='a-button-text a-declarative'])[37]")))).build()
		.perform();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-button-text a-declarative'])[37]")))
		.click();

		WebElement dropdown2_value = driver.findElement(By.id("Xiaomi_42"));
		dropdown2_value.click();
	}

	public void exchangeValueWillAppear() {
		String actualvalue = driver.findElement(By.id("buyBackOfferAppliedSuccessText")).getText();
		System.out.println();
		System.out.println("Fixed Exchange value:" + actualvalue);

	}
	
	public void userChangeSpecificationandClickOnDamageProtection()
	{
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.findElement(By.xpath("(//span[@class='a-size-base'])[9]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='mbb-offeringID-1']")).click();
		boolean selected = driver.findElement(By.xpath("//input[@id='mbb-offeringID-1']")).isSelected();
		System.out.println();
		System.out.println(selected);
	}
}
