package com.test.utilities;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class General4 {
	
	public static void main(String args[])
	{
		System.setProperty("webdriver..chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		c.addArguments("--incognito");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(ChromeOptions.CAPABILITY,c);
		c.merge(dc);
		WebDriver driver=new ChromeDriver(c);
		driver.get("D:\\3.html");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		
		if(wait.until(ExpectedConditions.alertIsPresent())==null);
		
		boolean a=driver.findElements(By.xpath("//div[@id='abc']")).size()>0;
				if(a==false)
				{
					System.out.println("elemnt not foung");
				}
				else
				{
					System.out.println("elemnt  foung");
				}
			
		driver.quit();
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.F5);
		
		WebElement element=driver.findElement(By.id("id"));
		File src=element.getScreenshotAs(OutputType.FILE);
		
Alert alert=driver.switchTo().alert();


	}

}
