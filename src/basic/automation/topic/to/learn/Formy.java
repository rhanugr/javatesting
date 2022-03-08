package basic.automation.topic.to.learn;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Formy 
{
	static String webdriver_key = "webdriver.chrome.driver";
	static String executeble_driver_value = ".//Drivers//chromedriver.exe";
	static String url = "https://formy-project.herokuapp.com/form";
	@Test
	public static void formyTest()
	{
		
		System.setProperty(webdriver_key, executeble_driver_value);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(url);
		fillForm(driver);
		
		driver.close();
		
	}
		public static void fillForm(WebDriver driver)
		{
			
			WebElement firstName = driver.findElement(By.id("first-name"));
			firstName.sendKeys("Hanamanta"+timeStamp(0));
			
			WebElement lastName = driver.findElement(By.id("last-name"));			
			lastName.sendKeys("Raghapur");
			
			WebElement educationGradSchool = driver.findElement(By.cssSelector("#radio-button-3"));
			educationGradSchool.click();
			
			WebElement sexMale = driver.findElement(By.xpath("//input[@id='checkbox-1']"));
			sexMale.click();
			
			WebElement datePicker = driver.findElement(By.cssSelector("#datepicker"));
			datePicker.sendKeys("03/08/2022");
			datePicker.sendKeys(Keys.RETURN);
			
			WebElement submit = driver.findElement(By.cssSelector("[class$='btn-primary']"));
			submit.click();				
			Assert.assertEquals("The form was successfully submitted!", verifyPage(driver));
		}
		public static String verifyPage(WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='alert-success']")));
			return successMessage.getText();
			
		}
		public static long timeStamp(long rn)
		{
			String timeStampValue = new SimpleDateFormat("yyyyMMddHHmmssss").format(new Date());
			rn = Long.parseLong(timeStampValue);
			return rn;
			
		}

}
