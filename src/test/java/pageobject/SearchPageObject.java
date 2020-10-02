package pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObject 
{
	WebDriver driver;

	private By product_List = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

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
				Assert.assertFalse("product no correctly displayed in the search result.product at index:",true);
			}
		}

	}
}
