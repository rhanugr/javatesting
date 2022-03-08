package basic.automation.topic.to.learn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsHandleTest 
{
	String currentURL = "";
	@Test
	public void windowHandle() throws InterruptedException {
		String webdriver_key = "webdriver.chrome.driver";
		String executeble_driver_value = ".//Drivers//chromedriver.exe";
		String url = "https://formy-project.herokuapp.com/switch-window";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		System.setProperty(webdriver_key, executeble_driver_value);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(url);
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		WebElement openNewTab = driver.findElement(By.id("new-tab-button"));
		openNewTab.click();
		
		String currentWindow = driver.getWindowHandle();
		String title2 ="";
		for(String windowHandle1: driver.getWindowHandles())
		{
			driver.switchTo().window(windowHandle1);
			title2 = driver.getCurrentUrl();
//			driver.close();
			Assert.assertNotEquals(currentURL, driver.getCurrentUrl());
		}
		Thread.sleep(10);
		
		driver.switchTo().window(currentWindow);
		
		Assert.assertEquals(currentURL, driver.getCurrentUrl());
		driver.quit();
		
	}

}
