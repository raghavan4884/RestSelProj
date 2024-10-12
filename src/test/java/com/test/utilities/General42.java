package com.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class General42 {
	
	private WebElement element;
	public static WebDriver driver;
	
	
	
	
	public WebElement getElement(String ele,String locator,String locatorType)
	{
		System.setProperty("webdriver.chrome.driver", "chormdriver.exe");
		driver=new ChromeDriver();
		switch(locatorType)
		{
		case "id":
		{
			element=driver.findElement(By.id("id"));
			break;
		}
		}
		return element;
	}

}
