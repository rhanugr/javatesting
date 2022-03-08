package browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BrowserTest 
{
	public WebDriver driver;
	@BeforeMethod
	public void open_browser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\JavaSeln\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://huberlin-bo.staging.moveon4.com/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);		
	}
	
	@AfterMethod
	public void close_browser() 
	{
		driver.close();
		driver.quit();		
				
	}

}
