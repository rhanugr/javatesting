package basic.automation.topic.to.learn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.lib.BasePage;

public class DragDropTest extends BasePage
{
	@Test
	public void dragDropTest() throws InterruptedException 
	{
		List<WebElement> clickDragDrops = driver.findElements(By.cssSelector("[class='btn btn-lg']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfAllElements(clickDragDrops));
		int val = clickDragDrops.size();
		System.out.println(val);
		
//		for(WebElement clickDrag : clickDragDrops)
//		{
//			if(clickDrag.getText().equals("Drag and Drop"))
//			{
//				clickDrag.click();
//			}
//		}
		WebElement dragDragDrop = driver.findElement(By.xpath("//div[@class='jumbotron-fluid']//a[@href='/dragdrop']"));
		dragDragDrop.click();
		
		WebElement from = driver.findElement(By.id("image"));		
		WebElement to = driver.findElement(By.id("box"));		
		
		
		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
		Thread.sleep(5000);
//		act.sendKeys(Keys.ENTER);
		WebElement droppedText = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id='box'] p")));
		String drop = droppedText.getText();
//				driver.findElement(By.cssSelector("[id='box'] p")).getText()
		Assert.assertEquals("Dropped", drop);
	}

}
