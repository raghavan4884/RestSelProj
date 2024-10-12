package com.test.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.lu.a;

public class General23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/books");
		WebElement selectElement=driver.findElement(By.xpath("//select"));
		Select select=new Select(selectElement);
		select.selectByValue("5");
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(300));
FluentWait<WebDriver> w=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(5)).ignoring(NoSuchElementException.class);
boolean b=false;
while(!b==true)
{
	List<WebElement> authorElement=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[contains(text(),'Nicholas C. Zakas')]"));
	WebElement btnElement=driver.findElement(By.xpath("//div[@class='-next']/button"));
	if(authorElement.size()>0)
	{
		b=true;
		System.out.println("element found");
	}
	else if(authorElement.size()==0)
	{
		b=false;
		btnElement.click();
	}
	
	
}
Actions actions=new Actions(driver);

driver.close();
	}

}
