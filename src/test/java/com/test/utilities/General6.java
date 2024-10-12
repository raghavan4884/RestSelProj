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

public class General6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
	WebDriver driver=new ChromeDriver(c);
	driver.get("http://the-internet.herokuapp.com/nested_frames");
	List<WebElement> element=driver.findElements(By.tagName("frame"));
	//System.currentTimeMillis();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(200));
	
	try
	{
		if((wait.until(ExpectedConditions.alertIsPresent())==null))
		{
			
		}
		else
		{
			driver.switchTo().alert().accept();
		}
	}
	catch(Exception e)
	{
		
	}
	long s=element.size();
	System.out.println(s);
	
	for(WebElement ele:element)
	{
		driver.switchTo().frame(ele);
		List<WebElement> dd=driver.findElements(By.xpath("//body[contains(text(),'BOTTOM')]"));
		
		if(dd.size()>0)
		{
			System.out.println("switched to correct frame");
			System.out.println("element is present");
		}
		
		else
		{
			System.out.println("element is not present");
			driver.switchTo().defaultContent();
			//driver.switchTo().parentFrame();
		}
		
	}
	}

}
