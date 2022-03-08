package basic.automation.topic.to.learn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class CompleteWebForm 
{
	String webdriver_key = "webdriver.chrome.driver";
	String executeble_driver_value = ".//Drivers//chromedriver.exe";
	String url = "https://formy-project.herokuapp.com/form";
	@Test
	public void completeWebForm()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		System.setProperty(webdriver_key, executeble_driver_value);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(url);
		
		String title =  driver.getTitle();
//		System.out.println(title);
		String expected_title = "Formy";
		Assert.assertEquals(title, expected_title);
		WebElement yearsOfExp = driver.findElement(By.id("select-menu"));
		Select select = new Select(yearsOfExp);
		select.selectByValue("2");
		
		WebElement submit = driver.findElement(By.xpath
				("//a[contains(@class,'btn-lg')]"));
		submit.click();		
		WebDriverWait wait =new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		
		WebElement successMessage =  driver.findElement(By.xpath
				("//div[contains(@class,'alert-success')]"));
		String messageAcutal = successMessage.getText();
		String messageExpected = "The form was successfully submitted!";
		Assert.assertEquals(messageAcutal, messageExpected);
		
		
		driver.quit();
	}
}
