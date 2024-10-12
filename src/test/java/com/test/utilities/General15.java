package com.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class General15 extends General14{

	private WebElement element;
	
	public WebElement getElement(String type,String name)
	{
		switch(type)
		{
		case "name":
		{
			element=driver.findElement(By.name(name));
			break;
		}
		
		}
		
		return element;
	}
	

}
