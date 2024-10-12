package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import com.test.utilities.XMLHandling;

public class WebElementMethods extends BrowserMethods{
	public WebElement getElement(String fileName,String webElement,String attribute)
	{
		WebElement element=null;
		XMLHandling xu=new XMLHandling();		
		String locatorType=xu.getXMLValueByAttribute(fileName, webElement, "type");
		String locatorValue=xu.getXMLValueByAttribute(fileName,webElement,"value");		
		switch(locatorType)
		{
		case "id":
		{
			element=driver.findElement(By.id(locatorValue));
			break;
		}
		case "name":
		{
			element=driver.findElement(By.name(locatorValue));
			break;
		}
		case "className":
		{
			element=driver.findElement(By.className(locatorValue));
			break;
		}
		case "tagName":
		{
			element=driver.findElement(By.tagName(locatorValue));
			break;
		}
		case "linkText":
		{
			element=driver.findElement(By.linkText(locatorValue));
			break;
		}
		case "partialLinkText":
		{
			element=driver.findElement(By.partialLinkText(locatorValue));
			break;
		}
		case "xpath":
		{
			element=driver.findElement(By.xpath(locatorValue));
			break;
		}
		case "cssSelector":
		{
			element=driver.findElement(By.cssSelector(locatorValue));
			break;
		}
		default:
		{
			System.out.println("please enter correct value");
			break;
		}
		
		}
		return element;
	}
	
	public String getElementInnerText(WebElement element)
	{
		return element.getText();
	}
	public String getElementAttributeValue(WebElement element,String key)
	{
		return element.getAttribute(key);
	}
	public String getCssOptionValue(WebElement element,String option)
	{
		//String s=element.getCssValue("color");
		
		return element.getCssValue(option);
	
	}
	public boolean verifyElementDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public boolean verifyElementEnabled(WebElement element)
	{
		return element.isEnabled();
	}
	public boolean verifyElementSelected(WebElement element)
	{
		return element.isSelected();
	}
	public void clearElement(WebElement element)
	{
		element.clear();
	}
	public void clickElement(WebElement element)
	{
		element.click();
	}
	public void submitElement(WebElement element)
	{
		element.submit();
	}
	public void enterValues(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	public void enterValues(WebElement element,Keys key)
	{
		element.sendKeys(key);
	}
	public int getElementHeight(WebElement element)
	{
		Dimension dimension=element.getSize();
		return dimension.getHeight();
	}
	public int getElementWidth(WebElement element)
	{
		Dimension dimension=element.getSize();
		
		return dimension.getWidth();
		
	}
	public int getElementXPosition(WebElement element)
	{
		Point p=element.getLocation();
		return p.getX();
	}
	public int getElementYPosition(WebElement element)
	{
		Point p=element.getLocation();
		return p.getY();
	}
	

}
