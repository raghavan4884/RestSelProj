package com.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class General38 extends General39{

	private WebElement element;
	
	public WebElement getElement(String name,String locator,String locatorName)
	{
		switch(locator)
		{
		case "xpath":
		{
			element=driver.findElement(By.xpath(locatorName));
			break;
		}
		}
		return element;
	}
	
	public void enterValue(WebElement webElement,String value)
	{
		webElement.sendKeys("java");
	}
	
}
