package stepdefs;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

		TakesScreenshot scrnShot = (TakesScreenshot)driver;
		byte[] data =scrnShot.getScreenshotAs(OutputType.BYTES);


		//scn.attach(data, "image/png", "screenshot_01");

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
		scn.log("Page title validation successfull. Actual title: " + actual );

	}

	@When("User Search for product {string}")
	public void user_search_for_product(String ProductName) {
		cmnpageobject = new CmnPageObject(driver);
		cmnpageobject.SetSearchTextBox(ProductName);
		cmnpageobject.ClickOnSearchBtn();
	}

	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed() {
		String expected = "Amazon.in : Redmi Note 9";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);

	}

	@Then("product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String ProductName) {
		searchpageobjects = new SearchPageObject(driver);
		searchpageobjects.ValidateProductList(ProductName);
	}

	@When("User click on any product")
	public void user_click_on_any_product() 
	{
		searchpageobjects = new SearchPageObject(driver);
		searchpageobjects.UserClickOnAnyProduct();

	}
	@Then("Product Description is displayed in new tab")
	public void product_description_is_displayed_in_new_tab() 
	{
		String ExpectedPageTitle = "Amazon.in : Redmi note 9";
		String ActualPageTitle = driver.getTitle();
		System.out.println("the actual page title is"+ActualPageTitle);
		Assert.assertTrue(ActualPageTitle.equalsIgnoreCase(ExpectedPageTitle));

	}


	@Then("User is click on Add to cart")
	public void user_is_click_on_add_to_cart() 
	{
		searchpageobjects = new SearchPageObject(driver);
		searchpageobjects.UserClickOnAddToCartBtn();
	}






}
