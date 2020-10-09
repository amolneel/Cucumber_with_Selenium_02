package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class CmnPageObject 
{
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;

	
	
	private  By Search_text_box = By.xpath("//input[@id='twotabsearchtextbox']");
	
	private By Search_btn = By.xpath("//input[@value='Go']");
	
	public CmnPageObject(WebDriver driver,Scenario scn)
	{
		this.scn = scn;
		this.driver = driver;
	}
	
	public void SetSearchTextBox(String text)
	{
		wait = new WebDriverWait(driver,60);
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(Search_text_box));
		element.sendKeys(text);
	}
	
	public void ClickOnSearchBtn()
	{
		driver.findElement(Search_btn).click();
	}
	
	
	

}



