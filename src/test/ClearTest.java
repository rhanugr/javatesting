package test;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sun.org.apache.xpath.internal.operations.Mult;

public class ClearTest {
	public static String url = "https://huberlin-bo.staging.moveon4.com/";
	/**
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void clear_text_box() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Tool\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		WebElement text = driver.findElement(By.id("ᐅloginᐅusername"));
		text.sendKeys("support@moveon4.com");			
		WebElement pw = driver.findElement(By.cssSelector("#ᐅloginᐅpassword"));
		pw.sendKeys("Moveon@30000");					
		driver.findElement(By.name("label_button_login")).click();
		
		WebElement menu = driver.findElement(By.xpath("//span[@role='presentation' and contains(text(),'Funding')]"));
//		Thread.sleep(10);
		menu.click();
		WebElement sub_menu = menu.findElement(By.xpath("../../../following-sibling::div//a[contains(text(),'Funding')]"));
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(menu));
		
//		Thread.sleep(10);		
		sub_menu.click();
//		wait.until(ExpectedConditions.elementToBeClickable(sub_menu));
		driver.findElement(By.xpath("//li[@class='actionsToolbarItem newIcon']//a[contains(text(),'New')]")).click();
		
		WebElement element = driver.findElement(By.id("ᐅtab_funding_newᐅfundingTypeId"));
		element.click();
		Select select = new Select(element);
		select.selectByVisibleText("Erasmus-SMP");
		
		List<WebElement> funding_type = driver.findElements(By.xpath("//select[@id='ᐅtab_funding_newᐅfundingTypeId']//option"));
//		List<WebElement> options = select.getOptions();
//		select.selectByIndex(options.size()-1);
		
		int count = funding_type.size();
		HashSet<String> alltext = new HashSet<String>();
		
		for(WebElement funding: funding_type) 
		{
			String allopti = funding.getText();
//			System.out.println(allopti);
			if(alltext.add(allopti)==false)
			{
				System.out.println(allopti);
			}
		}
		System.out.println("----------------");
		for(Object o:alltext)
		{
			System.out.println(o);
		}
//		System.out.println(alltext);
		WebElement logout = driver.findElement(By.cssSelector("#logout"));
//		logout.click();
		
		
		
		
//		driver.close();
	}
}
