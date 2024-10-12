package com.test.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver(c);
		driver.get("https://demo.automationtesting.in/Frames.html");
		WebElement element1=driver.findElement(By.partialLinkText("Iframe with"));
		element1.click();
		WebElement frame1=driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame1);
		
		List<WebElement> frame2=driver.findElements(By.tagName("iframe"));
		for(int i=0;i<frame2.size();i++)
		{
			
			driver.switchTo().frame(i);
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
			if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("\\input[@type='text']")))!=null)
			{
				WebElement txt_Element=driver.findElement(By.xpath("\\input[@type='text']"));
				txt_Element.sendKeys("Hi");
					
			}
			
			else
			{
				driver.switchTo().defaultContent();
			}
			
			
			
		
		}
		
			
	}

}
