package General;
/**
 * @author Chinmoy Saha
 *for all static variable for the project need
 */

interface IConstant 
{
	String user_profile=System.getProperty("user.dir");
	public static String browserdriveraddress=user_profile+".\\src\\driver\\chromedriver.exe";
	public static String browsername= "chrome";
	public static String driverbitcode="webdriver.chrome.driver";
	public static String url="https://www.nobroker.in/";
}
