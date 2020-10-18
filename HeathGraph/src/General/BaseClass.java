/**
 * 
 */
package General;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import helper.BrowserFactory;

/**
 * @author Chinmoy Saha
 *write down the before and after method in here
 */
public class BaseClass implements IConstant 
{
	protected WebDriver driver;
	@BeforeClass
	public void setupapplication() throws IOException
	{
		String url=IConstant.url;
		System.out.println(url);
		driver=BrowserFactory.StartBrowser(IConstant.browsername,url);
		driver.manage().window().maximize();
		Reporter.log("************browser started****************",true);
	}
	
	@AfterClass
	public void closedApplication()
	{
		driver.manage().deleteAllCookies();
		Reporter.log("************browser closed****************",true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

//	public static  WebDriver getDriver() {
//		return driver;
//	}

//	public void setDriver(WebDriver driver) {
//		this.driver = driver;
//	}

}
