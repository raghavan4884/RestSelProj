package com.test.selenium;

import org.openqa.selenium.WebElement;

public class FrameMethods extends BrowserMethods{

	public void switchFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	public void switchFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToParentFrame()
	{
		driver.switchTo().parentFrame();
	}
public void switchToDefaultContent()
{
	driver.switchTo().defaultContent();
}
	
	
}
