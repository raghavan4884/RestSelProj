package com.test.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class General10 {
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
	WebDriver driver=new ChromeDriver(c);
	driver.get("https://demoqa.com/automation-practice-form");
	driver.manage().window().maximize();
	//driver.get("http://the-internet.herokuapp.com/");
	//WebElement element=driver.findElement(By.linkText("Digest Authentication"));
	driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")).click();
	WebElement element=driver.findElement(By.xpath("//div[contains(@class,'current-month')]"));
	String dateYearVal=element.getText();	
	String[] s=dateYearVal.split(" ");
	String yr=s[1];
	String mo=s[0];
	//String year="2023";
	//String month="December";
	String dy="30";
	String month="December";
	String year="2023";
	while(!((mo.equals(month))&&(yr.equals(year))))
	{
		driver.findElement(By.xpath("//button[(text()='Next Month')]")).click();
		//break;
		//dateYearVal=element.getText();
		dateYearVal=element.getText();
		
		System.out.println(dateYearVal);
		mo=dateYearVal.split(" ")[0];
		yr=dateYearVal.split(" ")[1];
		
		
	}

	List<WebElement> dayList=driver.findElements(By.xpath("//div[contains(@class,'datepicker__day')]"));
	WebElement ele=driver.findElement(By.xpath("//div[contains(@aria-label,'"+mo+" "+dy+"')]"));
	//WebElement notDay=driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--outside')]"));
	
	
	for(WebElement day:dayList)
	{
		
		
		if(day.getText().equals(dy))
		{
			ele.click();
		}
		
	}	
	
	
	//element.click();
	//driver.get("http://admin:admin@the-internet.herokuapp.com/digest_auth");
	
	}

}
