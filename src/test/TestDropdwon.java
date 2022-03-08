package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDropdwon {

	@Test(enabled=false)
	public void dropdowntest() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\JavaSeln\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement dropdwon = driver.findElement(By.id("dropdown-class-example"));		
		Select sel = new Select(dropdwon);			
		List<WebElement> alloptions = sel.getOptions();		
		int size = alloptions.size();
		System.out.println(size);		
		sel.selectByIndex(3);		
		System.out.println("PASS");
		
	}
	@Test(enabled=false)
	public void handlecheckbox()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\JavaSeln\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> checkBox = driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));		
		int count = checkBox.size();		
		System.out.println(count);
		for(WebElement check:checkBox)
		{
			check.click();
			
		}
	}
	@Test(enabled=false)
	public void handlesuggestiondropdwon() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\JavaSeln\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Am");
		List<WebElement> sel = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		int count = sel.size();
		for(int i=0; i<count; i++)
		{
			String countries = sel.get(i).getText();
			System.out.println(countries);
			if(countries.equals("Gambia"))
			{
				sel.get(i).click();
				break;
			}
		}
	
		
		
	}

	@Test
	public void tableTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\JavaSeln\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='product-action']/button"));
//		WebElement vegies_name = button.findElement(By.xpath("../../h4"));
		List<String>  vegies = new ArrayList<String>();
		for(WebElement element : buttons)	
		{
				String vegsName = element.findElement(By.xpath("../../h4")).getText();
//				System.out.println(vegsName);
				vegies.add(vegsName);
				element.click();
		}
		driver.findElement(By.cssSelector(".cart-icon img")).click();
		driver.findElement(By.xpath("//div[@class='action-block']//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		List<WebElement> confirm = driver.findElements(By.xpath("//p[@class='product-name']"));
		List<String> vegs = new ArrayList<String>();
		
		for(WebElement actual:confirm)
		{
			String vegies1 = actual.getText();
			vegs.add(vegies1);
			
		}
//		Assert.assertEquals(vegies, vegs);
		
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
	}
}
