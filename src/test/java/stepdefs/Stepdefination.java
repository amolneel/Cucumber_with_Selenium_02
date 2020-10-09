package stepdefs;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobject.CmnPageObject;
import pageobject.SearchPageObject;

public class Stepdefination {
	WebDriver driver;
	String base_url = "https://amazon.in";
	int implicit_wait_timeout_in_sec = 20;
	CmnPageObject cmnpageobject = null;
	SearchPageObject searchpageobjects = null;
	Scenario scn;

	@Before
	public void Setup(Scenario scn) {
		this.scn = scn;

	}

	@After
	public void QuiteAll() {

		
		
		TakesScreenshot scrnShot = (TakesScreenshot) driver;
		byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);		
		driver.quit();
		scn.log("User quit the browser!...");

	}

	@Given("User opened Browser")
	public void user_opened_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
		scn.log("user opened browser successfully!...");

	}

	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() {
		driver.get(base_url);
		scn.log("Browser navigated to URL: " + base_url);
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		Assert.assertEquals("Page Title validdation", expected, actual);
		scn.log("Page title validation successfull. Actual title: " + actual);

	}

	@When("User Search for product {string}")
	public void user_search_for_product(String ProductName) {
		cmnpageobject = new CmnPageObject(driver,scn);
		cmnpageobject.SetSearchTextBox(ProductName);
		cmnpageobject.ClickOnSearchBtn();
		scn.log("user search product successfully!...");
	}

	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed() {
		String expected = "Amazon.in : Redmi Note 9";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
		scn.log("search result page is displayed successfully!...");

	}

	@Then("product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String ProductName) {
		searchpageobjects = new SearchPageObject(driver,scn);
		searchpageobjects.ValidateProductList(ProductName);
		scn.log("product list apeared successfully!...");
	}

	@When("User click on any product")
	public void user_click_on_any_product() {
		searchpageobjects = new SearchPageObject(driver,scn);
		searchpageobjects.UserClickOnAnyProduct();
		scn.log("user clicked on product successfully!...");

	}

	@Then("Product Description is displayed in new tab")
	public void product_description_is_displayed_in_new_tab() {
		String ExpectedPageTitle = "Amazon.in : Redmi note 9";
		String ActualPageTitle = driver.getTitle();
		System.out.println("the actual page title is" + ActualPageTitle);
		Assert.assertTrue(ActualPageTitle.equalsIgnoreCase(ExpectedPageTitle));
		scn.log("product descriprion is displayed successfully!...");

	}

	@Then("User is click on Add to cart")
	public void user_is_click_on_add_to_cart() {
		searchpageobjects = new SearchPageObject(driver,scn);
		searchpageobjects.UserClickOnAddToCartBtn();
		scn.log("user clicked on add to cart btn successfully!...");
	}

	@Then("User clicked on with exchange button")
	public void user_clicked_on_with_exchange_button() {
		searchpageobjects = new SearchPageObject(driver,scn);
		searchpageobjects.UserClickedOnExchangeBtn();
		scn.log("user clicked on exchange btn successfully!...");

	}

	@When("User clicked on choose phone to exchange")
	public void user_clicked_on_choose_phone_to_exchange() {
		searchpageobjects = new SearchPageObject(driver,scn);
		searchpageobjects.UserClickedOnChoosePhoneToExchange();
		scn.log("user clicked on phone to exchange btn successfully!...");

	}

	@When("User select brand of mobile and select model")
	public void user_select_brand_of_mobile_and_select_model() {
		searchpageobjects = new SearchPageObject(driver,scn);
		searchpageobjects.UserSelectBrand_ModelOfMobile();
		scn.log("user select brand and model successfully!...");

	}

	@Then("fixed exchange value will appear")
	public void fixed_exchange_value_will_appear() {
		searchpageobjects = new SearchPageObject(driver,scn);
		searchpageobjects.exchangeValueWillAppear();
		scn.log("exchange value will appeared successfully!...");

	}
	
	@Then("User chang the specification and click on One year total damage protection")
	public void user_chang_the_specification_and_click_on_one_year_total_damage_protection()
	{
		searchpageobjects = new SearchPageObject(driver,scn);
		searchpageobjects.userChangeSpecificationandClickOnDamageProtection();
		scn.log("user change specification and click on protection successfully!...");
	}


}
