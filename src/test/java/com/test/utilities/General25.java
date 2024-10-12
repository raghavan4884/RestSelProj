package com.test.utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver(c);
		//driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		if(ExpectedConditions.alertIsPresent().apply(driver)!=null)
		{
			Alert alert=driver.switchTo().alert();
				alert.accept();
				
			//driver.switchTo().alert().accept();
		
			}
		else
		{
			System.out.println(driver.getTitle());
			driver.quit();
		}
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("id"));
		//wait.until(ExpectedConditions.titleIs("Google"));
		//System.out.println(driver.getTitle());
		
		/*if(ExpectedConditions.frameToBeAvailableAndSwitchToIt("id")!=null)
		{
			try
			{
				driver.switchTo().frame("id");
			}
			catch(NoSuchFrameException e)
			{
				e.printStackTrace();
			}
		}*/
	/*	else if(ExpectedConditions.alertIsPresent().apply(driver)!=null)
		{
			try
			{
				driver.switchTo().alert().accept();
			}
			catch(NoAlertPresentException e)
			{
				e.printStackTrace();
			}
		}*/
		/*else
		{
			System.out.println(driver.getTitle());
			driver.quit();
		}*/
		

	}

}
