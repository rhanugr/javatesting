package basics;
import java.sql.DriverManager;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import browser.BrowserTest;

public class Ran extends BrowserTest
{
	
	@Test 
	public void Test() throws InterruptedException 
	{
//		System.setProperty("webdriver.chrome.driver", "C:\\JavaSeln\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://huberlin-bo.staging.moveon4.com/");
		System.out.println("Open Browser");
		driver.findElement(By.id("ᐅloginᐅusername")).sendKeys("support@moveon4.com");
		driver.findElement(By.name("password")).sendKeys("Moveon@30000");
		driver.findElement(By.name("label_button_login")).click();	
		WebElement settings_menu = driver.findElement(By.xpath("//span[@role='presentation' and contains(text(),'Settings')]"));
		WebElement sub_menu = settings_menu.findElement(By.xpath("../../../following-sibling::div//span[contains(text(),'Administration')]"));
		
		WebElement child_menu = settings_menu.findElement(By.xpath("../../../following-sibling::div//a[contains(text(),'Academic periods')]"));
		
		settings_menu.click();
		sub_menu.click();
		Thread.sleep(5);
		
		child_menu.click();
				
		driver.findElement(By.xpath("//li[@class='actionsToolbarItem newIcon']//a[contains(@title,'New')]")).click();
		driver.findElement(By.id("ᐅtab_academic_period_newᐅname")).sendKeys("Test_User3");
		WebElement academic_year = driver.findElement(By.id("ᐅtab_academic_period_newᐅacademicYearId"));
		academic_year.click();
		Select select = new Select(academic_year);
		select.selectByVisibleText("2022/23");
		Thread.sleep(1);
		driver.findElement(By.name("shortname")).sendKeys("KatalonJava");
		
		List<WebElement> sels = driver.findElements(By.id("ᐅtab_academic_period_newᐅorder"));
		
		Random rn = new Random();
		for(WebElement sel:sels)
		{
			List<WebElement> options = driver.findElements(By.xpath("//select[@id='ᐅtab_academic_period_newᐅorder']//option"));
			int list = rn.nextInt(options.size());
			
			options.get(list).click();		
			
		}
		Thread.sleep(4);
		driver.findElement(By.xpath("(//li[@class='actionsToolbarItem']//a[contains(text(),'Save')])[1]")).click();
		String success_message = driver.findElement(By.xpath("//div[contains(@id,'statusMessage')]")).getText();
		String message = "The new entry has been added successfully.";
		Assert.assertEquals(success_message, message);
	}

}
