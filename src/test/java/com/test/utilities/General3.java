package com.test.utilities;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class General3 {
	
	public static void main(String args[])
	{
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
	WebDriver driver=new ChromeDriver(c);
	driver.get("D:\\2.html");
	WebElement element=driver.findElement(By.xpath("//select[@value='volvo']"));	
	Select select=new Select(element);
	List<WebElement> allValues=select.getOptions();
	List<String> j=new ArrayList<>();
	j.add("Benz");
	j.add("Cars");
	
	for(WebElement zz:allValues)
	{
		String kk=zz.getText();
		for(String ww:j)
		{
			if(kk.equals(ww))
			{
				System.out.println("equals");
			}
			else 
			{
				System.out.println("Not equals");
			}
		}
	}
	
	allValues.stream().forEach(x->System.out.println(x.getText()));
	
	
	
	
	
	
	}

}
