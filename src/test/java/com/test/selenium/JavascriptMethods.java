package com.test.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavascriptMethods extends BrowserMethods{
	
	public void clickElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void getPageLoadStatus()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("return document.readyState").toString();
	}
	public void ClickElement(String id)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByID().click();");
	}
	public void enterValue(String id,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByID().value='"+value+"';");
	}
	
	

}
