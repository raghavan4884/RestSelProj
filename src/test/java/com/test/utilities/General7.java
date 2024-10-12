package com.test.utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;



public class General7 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_0);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
	WebDriver driver=new ChromeDriver(c);
	driver.get("http://www.google.com");
	WebElement btn_srch=driver.findElement(By.name("btnK"));
	String colour=btn_srch.getCssValue("color");
	System.out.println(colour);
	//String colours=Color.fromString(colour).asHex();
	String colours=Color.fromString(colour).asHex();
	System.out.println(colours);
	if(colours.equals("#3c4043"))
	{
		System.out.println("Equals");
	}
	else
	{
		System.out.println("not Equals");
	}
	
	btn_srch.sendKeys(Keys.chord(Keys.SHIFT,Keys.ENTER));
	Select select=new Select(btn_srch);
	
	System.currentTimeMillis();
	
//	
		String fileName="1.xlsx";
		String extension=fileName.substring(fileName.indexOf('.'));
		System.out.println(extension);
		
	}
}
