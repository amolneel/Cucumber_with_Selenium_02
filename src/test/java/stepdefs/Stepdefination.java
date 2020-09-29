package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Stepdefination
{
	WebDriver  driver;
	String base_url = "https://amazon.in";
	int implicit_wait_timeout_in_sec = 20;

	@Given("User opened Browser")
	public void user_opened_browser() 
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);

	}
	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() 
	{
		driver.get(base_url);
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		Assert.assertEquals( "Page Title validdation", expected,actual);

	}
	@When("User Search for product {string}")
	public void user_search_for_product(String ProductName) 
	{
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(ProductName);
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Go']")).click();

	}
	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed() 
	{
		String expected = "Amazon.in : Laptop";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
		driver.quit();

	}




}
