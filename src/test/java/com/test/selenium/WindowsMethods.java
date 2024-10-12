package com.test.selenium;

import java.util.Set;

public class WindowsMethods extends BrowserMethods {
	
	public String getWindow()
	{
		return driver.getWindowHandle();
	}
	
	public Set<String> getWindows()
	{
		return driver.getWindowHandles();
	}
	public void switchWindow(String windowName)
	{
		driver.switchTo().window(windowName);
	}

}
