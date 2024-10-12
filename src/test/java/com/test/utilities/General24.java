package com.test.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General24 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver(c);
		//driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.get("http://the-internet.herokuapp.com/frames");
		driver.manage().window().maximize();
		//WebElement element=driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		//WebElement element=driver.findElement(By.xpath("//ul//li[3]/button"));
		WebElement element=driver.findElement(By.xpath("//a[text()='Nested Frames']"));
		
		element.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@name='frame-top']")));
		
				List<WebElement> elements=driver.findElements(By.xpath("//frame"));
				System.out.println(elements.size());
				//WebElement e=driver.findElement(By.xpath("//html//body[contains(text(),'RIGHT')]"));
				for(WebElement frmElement:elements)
				{
					System.out.println("hi");
					driver.switchTo().frame(frmElement);
					if(driver.findElements(By.xpath("//html//body[contains(text(),'RIGHT')]")).size()>0)
					{
						System.out.println("elemnt found in the frame");
						break;
					}
					else
					{
						System.out.println("elemnt not found in the frame");
						driver.switchTo().parentFrame();	
					}
				
			}
		
				driver.quit();
		}
		
		
		/*Actions act=new Actions(driver);
		act.click(element);
		act.doubleClick(element).perform();
		Action ac=act.build();
		ac.perform();
		*/
		
		
		
		//element.click();
		
		/*WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		if(wait.until(ExpectedConditions.alertIsPresent())!=null)
		{
			try {
				
				Alert alert= driver.switchTo().alert();
				
				System.out.println(alert.getText());
				alert.sendKeys("Hi");
				Thread.sleep(1000);
				alert.accept();
			
			} catch (NoAlertPresentException e) {
				// TODO: handle exception
				
			}
			
		}*/
		/*System.out.println(ExpectedConditions.alertIsPresent().apply(driver));
		boolean b=ExpectedConditions.alertIsPresent()!=null;
		if(b)
		{
			Alert alert= driver.switchTo().alert();
			
			System.out.println(alert.getText());
			alert.sendKeys("Hi");
			Thread.sleep(1000);
			alert.accept();
			
		}*/
		//System.out.println(ExpectedConditions.alertIsPresent().apply(driver));
		//System.out.println(ExpectedConditions.alertIsPresent().apply(driver));
		//System.out.println(ExpectedConditions.titleIs("Google1").apply(driver));
		
/*		if(ExpectedConditions.alertIsPresent().apply(driver)!=null)
		{
			driver.switchTo().alert();
		}
		else
		{
			System.out.println("No Alert is preesenet");
		}
*/		/*if(ExpectedConditions.titleIs("Google").apply(driver)==true)
		{
		System.out.println("Tilte is present");	
		}

		else
		{
			System.out.println("title is not presdent");	
		}
*/		

			//driver.close();
	

}
