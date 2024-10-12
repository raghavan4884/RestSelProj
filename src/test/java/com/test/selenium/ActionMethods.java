package com.test.selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionMethods extends BrowserMethods{

	Actions actions=new Actions(driver);
	public void clickElement(WebElement element)
	{
		
		actions.click(element).build().perform();
	}
	
	public void doubleClickElement(WebElement element)
	{
		actions.doubleClick(element).build().perform();
	}
	public void rightClickElement(WebElement element)
	{
		actions.contextClick(element).build().perform();
	}
	public void moveToelement(WebElement element)
	{
		actions.moveToElement(element).build().perform();
	}
	public void dragAndDrop(WebElement source,WebElement target)
	{
		actions.dragAndDrop(source, target).build().perform();
	}
	public void keyPress(Keys key)
	{
		actions.keyDown(key).build().perform();
	}
	public void keyRelease(Keys key)
	{
		actions.keyUp(key).build().perform();
	}
}
