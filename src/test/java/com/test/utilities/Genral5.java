package com.test.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.common.base.Objects;

import junit.framework.Assert;

public class Genral5 {

	String s="aaaa";
	public String a()
	{
		
		return s;
	}
	public static void main(String ags[])
	{
		System.setProperty("webdriver..chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver(c);
		driver.get("https://www.google.com");
		WebElement element=driver.findElement(By.name("q"));
		Actions act=new Actions(driver);
		act.keyDown(element,"a").build().perform();
		act.keyUp(element,"a").build().perform();
		List<String> l=new ArrayList<>();
		
		l.add("abcd");
		l.add("acd");
		l.add("aaaa");
		//l.stream().filter(x->Objects.equal("aaaa", x.a()));
		
	}
	
}
