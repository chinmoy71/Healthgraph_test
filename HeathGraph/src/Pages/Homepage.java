package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;



public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(how=How.ID,using="nbCitySelector")
	public
	WebElement drop_city_selector;
	@FindBy(how=How.ID,using="locationGoogle")
	public
	WebElement txt_input_location;
	@FindBy(how=How.ID,using="searchButtonHomePage")
	public
	WebElement btn_search_item;
	@FindBy(how=How.ID,using="nbBHKSelector")
	public
	WebElement drop_nhk_selector;
	@FindBy(how=How.ID,using="shortDesc")
	public
	WebElement descrpition;
	
	public void select_location(String location) throws InterruptedException, AWTException
	{
		txt_input_location.sendKeys(location);
		Thread.sleep(2000);
		Robot re=new Robot();
		try {
			re = new Robot();
			re.keyPress(KeyEvent.VK_DOWN);
			re.keyRelease(KeyEvent.VK_DOWN);
			re.keyPress(KeyEvent.VK_ENTER);
			re.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}
	public void select_flat_type(String flatdescrpition1) throws InterruptedException
	{
		drop_nhk_selector.click();
		elementfinder(flatdescrpition1).click();
		Thread.sleep(5000);		
	}
	public WebElement elementfinder(String id)
	{
		WebElement ele=driver.findElement(By.xpath("//input[@id='" + id + "']"));
		return  ele;
	}
	public void  searchitem(String item_number) throws InterruptedException
	{
		Thread.sleep(10000);
		By Xpath=By.xpath("//div[@class='card'][" +item_number+ "]");
		scrollTo(Xpath);
		WebElement ele=driver.findElement(Xpath);
		ele.click();
		String parentWindow = driver.getWindowHandle();
		String subWindowHandler1 = "";
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();
		while (iterator.hasNext())
		{
		   subWindowHandler1 = iterator.next();
		   if(!parentWindow.equalsIgnoreCase(subWindowHandler1))
		   {
			   
			   driver.switchTo().window(subWindowHandler1);
			   String text=descrpition.getText();
			   if(text!="")
			   {
				   Assert.assertTrue(true);
			   }
			   else
			   {
				   Assert.fail();
			   }
			   
		   }
		   }
	}
	public void scrollTo(By locator) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				driver.findElement(locator));
	}
}
