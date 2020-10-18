package helper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import General.BaseClass;


public class BrowserFactory extends BaseClass
{
	 static WebDriver driver;
	public static WebDriver StartBrowser(String browsername,String url)
	{
		if(browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty(BaseClass.driverbitcode,BaseClass.browserdriveraddress);
			 Map<String, Object> prefs = new HashMap<String, Object>();
			 prefs.put("download.default_directory",System.getProperty("user.dir") + File.separator + "src" + File.separator + "download");
			 ChromeOptions options = new ChromeOptions();
			 options.setExperimentalOption("prefs", prefs);
			 driver= new ChromeDriver(options);
			 driver.manage().deleteAllCookies();
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		else if(browsername.equalsIgnoreCase("EdgeDriver"))
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
