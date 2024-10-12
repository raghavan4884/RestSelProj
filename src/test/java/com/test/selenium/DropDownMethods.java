package com.test.selenium;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownMethods {
	
	public Select getSelect(WebElement element)
	{
		Select select=new Select(element);
		return select;
	}
	
	public void selDeselElement(WebElement element,String option,String value)
	{
		switch(option)
		{
		case "selectByValue":
		{
			getSelect(element).selectByValue(value);
			break;
		}
		case "selectByVisibileText":
		{
			getSelect(element).selectByVisibleText(value);
			break;
		}
		case "selectByIndex":
		{
			int index=Integer.parseInt(value);
			getSelect(element).selectByIndex(index);
			break;
		}
		case "deselectByValue":
		{
			getSelect(element).deselectByValue(value);
			break;
		}
		case "deselectByVisibileText":
		{
			getSelect(element).deselectByVisibleText(value);
			break;
		}
		case "deselectByIndex":
		{
			int index=Integer.parseInt(value);
			getSelect(element).deselectByIndex(index);
			break;
		}
		default:
		{
			System.out.println("enter the correct option");
			break;
		}
		}
		
	}
	public void deselectAllValues(WebElement element)
	{
		getSelect(element).deselectAll();
	}
	public boolean selectMultiple(WebElement element)
	{
		return getSelect(element).isMultiple();
	}
	public WebElement getFirstSelOption(WebElement element)
	{
		return getSelect(element).getFirstSelectedOption();
	}
	public List<WebElement> getAllOptions(WebElement element)
	{
		return getSelect(element).getOptions();
	}
	public List<WebElement> getSelectedOptions(WebElement element)
	{
		return getSelect(element).getAllSelectedOptions();
	}
	
	

}
