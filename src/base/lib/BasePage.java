package base.lib;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BasePage 
{
	private static String webdriver_key = "webdriver.chrome.driver";
	private static String executeble_driver_value = ".//Drivers//chromedriver.exe";
	private static String url = "https://formy-project.herokuapp.com/";
	protected WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		System.setProperty(webdriver_key, executeble_driver_value);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(url);
	}
	@AfterMethod
	public void closeBrowser()	
	{
		driver.close();
		driver.quit();
	}

}
