package com.test.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import groovyjarjarantlr4.v4.codegen.SourceGenTriggers.alt_return;

public class General20 {
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		WebElement element=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		element.click();
		WebElement MonthAndYear=driver.findElement(By.xpath("//div[contains(@class,'current-month')]"));
		String monthYear=MonthAndYear.getText();
		String[] my=monthYear.split(" ");
		String month=my[0];
		String year=my[1];
		WebElement nextElement=driver.findElement(By.xpath("//button[@aria-label='Next Month']"));
		String m="May";
		String y="2024";
		String day="3";
		//String ss=null;
		while(!((month.equals(m))&&(year.equals(y))))
		{
			nextElement.click();
		}
		List<WebElement> ll=driver.findElements(By.xpath(""));
		

	}

}
