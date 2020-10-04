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

public class SearchPageObject 
{
	WebDriver driver;

	private By product_List = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
	private By click_on_product = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
	private By add_to_cart = By.xpath("//input[@id='add-to-cart-button']");
	

	public SearchPageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	public void ValidateProductList(String ProductName)
	{
		List<WebElement> list_of_products = driver.findElements(product_List);

		for(int i = 0; i<list_of_products.size(); i++)
		{
			if(list_of_products.get(i).getText().toLowerCase().contains(ProductName.toLowerCase()))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertFalse("product no correctly displayed in the search result.product at index:-"+ProductName,false);
			}
		}

	}
	
	public void UserClickOnAnyProduct()
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		
		 Actions action = new Actions(driver);

			List<WebElement> List_of_product =driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			
			for(int i = 1;i<=List_of_product.size();i++)
				action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")))).build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"))).click();

		
	}
	
	public void UserClickOnAddToCartBtn()
	{
		Set<String> handles =driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentwindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
	}
}
