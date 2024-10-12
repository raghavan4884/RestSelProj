package com.test.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class General11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver(c);
		driver.get("D:\\2.html");
		WebElement element=driver.findElement(By.id("cars"));
		Select select=new Select(element);
		List<WebElement> list=select.getOptions();
		String s[]={"Saab","Audi"};
		
		int flag=0;
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<s.length;j++)
			{
				if(list.get(i).getText().equals(s[j]))
				{
					
					System.out.println("element found"+s[j]);
					select.selectByVisibleText(s[j]);
					//select.selectByValue(s[j]);
					
				}
				
			}
		}
		
	}
}
