package com.test.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class General12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver(c);				
		driver.get("https://www.google.com");
		Actions actions=new Actions(driver);
		driver.manage().window().maximize();		
		actions.sendKeys(Keys.chord(Keys.CONTROL,"t"));
		driver.get("https://www.yahoo.com");
		
		
	}

}
